#include <stdio.h>
int main() {
    double x_plus_y, x_minus_y, x, y;

    scanf("%lf %lf", &x_plus_y, &x_minus_y);
    x = (x_plus_y + x_minus_y ) / 2;
    y = (x_plus_y - x_minus_y) / 2;
    printf("x = %.2lf\ny = %.2lf\n", x, y);
}