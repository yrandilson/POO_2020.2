#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int raizes(float a, float b, float c, float *x1, float *x2){
  float discriminante;
  int total_raizes;

  discriminante = (b*b)-(4*a*c);

  if(discriminante < 0){
    total_raizes = 0;
  }
  else if(discriminante == 0){
    total_raizes = 1;
    *x1= -b/(2*a);
    *x2 = *x1;
  }
  else{
    total_raizes = 2;
    *x1 = (-b-sqrt(discriminante))/(2*a);
    *x2 = (-b+sqrt(discriminante))/(2*a);

  }
  return total_raizes;
  }

int main(){
  float a, b, c, raiz1, raiz2;
  int total_raizes;
  printf("Entre com os coeficientes: \n");
  scanf("%f%f%f", &a, &b, &c);

  total_raizes = raizes(a, b, c, &raiz1, &raiz2);

  if(total_raizes == 0){
    printf("Não há raizes");
  }else{
    printf("As raizes são %f e %f", raiz1, raiz2);
  }
  return 0;
}
