#include <stdio.h>
#include <stdlib.h>
//升序
void BubbleSort(int arr[], int size){
	//以每次找最小为例
	//[0,bound)已排序区间
	//[bound,size)待排序区间
	for (int bound = 0; bound < size ; bound++){
		for (int cur = size - 1; cur>bound; cur--){
			if (arr[cur - 1] > arr[cur]){
				int tmp = arr[cur - 1];
				arr[cur - 1] = arr[cur];
				arr[cur] = tmp;
			}
		}
	}
}

int main(){
	int arr[4] = { 9, 5, 2, 7 };
	BubbleSort(arr, 4);
	for (int i = 0; i < 4; i++){
		printf("%d ", arr[i]);
	}
	printf("\n");
	system("pause");
	return 0;
}