#include <stdio.h>
#include <stdlib.h>
//����
void BubbleSort(int arr[], int size){
	//��ÿ������СΪ��
	//[0,bound)����������
	//[bound,size)����������
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