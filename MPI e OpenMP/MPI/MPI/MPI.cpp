#include <iostream>
#include <mpi.h>

using namespace std;

int main(int args, char** argvs)
{
	cout << "Hello world" << endl;
	int rank = 0, numOfProcess = 0;
	MPI_Init(&args, &argvs);
	MPI_Comm_rank(MPI_COMM_WORLD, &rank);
	MPI_Comm_size(MPI_COMM_WORLD, &numOfProcess);
	cout << "Hello world from process rank(number): " << rank << numOfProcess;
	MPI_Finalize();
}