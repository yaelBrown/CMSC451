package hw;

// Floyds Algorithm

public class Homework6 {
    public static void main(String[]args)

    {

//Create a 2D array of size 5*5

        int[][] a =new int[5][5];

//initializing the array by the values of matrix

        a[0][0]=0;

        a[0][1]=0;

        a[0][2]=0;

        a[0][3]=0;

        a[0][4]=1;

        a[1][0]=1;

        a[1][1]=0;

        a[1][2]=0;

        a[1][3]=0;

        a[1][4]=0;

        a[2][0]=0;

        a[2][1]=0;

        a[2][2]=1;

        a[2][3]=1;

        a[2][4]=0;

        a[3][0]=0;

        a[3][1]=0;

        a[3][2]=1;

        a[3][3]=0;

        a[3][4]=0;

        a[4][0]=1;

        a[4][1]=0;

        a[4][2]=1;

        a[4][3]=0;

        a[4][4]=1;

        int count =1;

//Call the method matrix

        matrix(count,a);

//Print the final matrix

        for(int i=0;i<5;i++){

            for(int j=0;j<5;j++)

            {

                System.out.print(a[i][j]+" ");

            }

            System.out.println();

        }

    }

//method matrix with 2 parameters

    static void matrix(int count, int[][] a)

    {

        int[][] D =new int[5][5];

//updating the matrix

        for(int i=0;i<5;i++)

        {

            for(int j=0;j<5;j++)

            {

                int num=a[i][count]+a[count][j];

                if(num<a[i][j])

                {

                    D[i][j]=num;

                }

                else

                    D[i][j]=a[i][j];

            }

        }

//copying matrix D to a

        for(int i=0;i<5;i++)

        {

            for(int j=0;j<5;j++)

            {

                a[i][j]=D[i][j];

            }

        }

        while(count<4)

        {

            count++;

            matrix(count,a);

        }

    }

}
