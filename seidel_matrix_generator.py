import sys
from random import randint

def main(argv):
	numberOfVertices = 0
	try:
		numberOfVertices = abs(int(argv[1]))
	except:
		print "Wrong execution!"
		print "Syntax:\t%s: <number_of_vertices>" % argv[0]
		return sys.exit(1)

	fileName = "tst/seidel_matrix_%dx%d.txt" % (numberOfVertices, numberOfVertices)

	file = open(fileName, 'w')

	file.write("%d\n" % (numberOfVertices))

	upperLimit = numberOfVertices*2

        matrix = [[0 for x in range(numberOfVertices)] for y in range(numberOfVertices)];

	for i in range(numberOfVertices):
		for j in range(numberOfVertices):
                        if j >= i:
                                continue

			randomNumber = randint(1,upperLimit)

			if randomNumber > upperLimit*3/4.:
				randomNumber = 0
                        else:
                                randomNumber = 1;
                        matrix[i][j] = randomNumber;
                        matrix[j][i] = randomNumber;

        for i in range(numberOfVertices):
                for j in range(numberOfVertices):
                        file.write( "%d " % (matrix[i][j]))
                file.write("\n")

	file.close()

	return sys.exit(0)


if __name__ == "__main__":
   main(sys.argv[0:2])
