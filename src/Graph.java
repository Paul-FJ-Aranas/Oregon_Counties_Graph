import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {

	CountyVertex[] adjacencyList;

	public Graph(String inputFileName) throws FileNotFoundException {
		// input a file with an integer as size of file followed by names of
		// vertices
		// then a list of pairs of vertices and neighbors
		Scanner scanner = new Scanner(new File(inputFileName));

		adjacencyList = new CountyVertex[scanner.nextInt()];

		// Here we are going to read those vertices from the file

		for (int i = 0; i < adjacencyList.length; i++) {

			adjacencyList[i] = new CountyVertex(scanner.next(), null);
		}

		// Here we will read the edges from the file

		while (scanner.hasNext()) {

			int vertex_1 = getVertexIndex(scanner.next());
			int vertex_2 = getVertexIndex(scanner.next());

			adjacencyList[vertex_1].firstInList = new CountyNeighbor(vertex_2, adjacencyList[vertex_1].firstInList);

			// We are going for an undirected graph here, thus we switch the
			// vertices

			adjacencyList[vertex_2].firstInList = new CountyNeighbor(vertex_1, adjacencyList[vertex_2].firstInList);

		}
		scanner.close();
	}

	int getVertexIndex(String vertexName) {

		for (int i = 0; i < adjacencyList.length; i++) {

			if (adjacencyList[i].countyName.equals(vertexName)) {
				return i;
			}
		}
		return -1;
	}
}

class CountyNeighbor {

	CountyNeighbor next;
	int vertexNumber;

	public CountyNeighbor(int vertexNumber, CountyNeighbor neighbor) {

		this.next = neighbor;
		this.vertexNumber = vertexNumber;

	}

}

class CountyVertex {
	String countyName;
	CountyNeighbor firstInList;

	public CountyVertex(String name, CountyNeighbor neighbors) {
		this.firstInList = neighbors;
		this.countyName = name;

	}

}
