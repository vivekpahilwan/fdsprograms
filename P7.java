import java.util.Scanner;

class SparseMat {
    public int[][] mat;
    public int row, column;
    public int size;

    SparseMat() {
    }

    SparseMat(int[][] m) {
        size = 0;
        row = m.length;
        column = m[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (m[i][j] != 0) {
                    size++;
                }
            }
        }
        this.size = size;

        this.mat = new int[size][3];
        int x = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (m[i][j] != 0) {
                    mat[x][0] = i;
                    mat[x][1] = j;
                    mat[x][2] = m[i][j];
                    x++;
                }
            }
        }
    }

    public SparseMat simpleTranspose(){
        SparseMat mat = new SparseMat();
        mat.row = row;
        mat.column = column;
        mat.size = size;

        mat.mat = new int[size][3];

        int k = 0, counter = 0;

        while (k < column) {
            for (int i = 0; i < size; i++) {
                if (this.mat[i][1] == k) {
                    mat.mat[counter][0] = this.mat[i][1];
                    mat.mat[counter][1] = this.mat[i][0];
                    mat.mat[counter][2] = this.mat[i][2];
                    counter++;
                }
            }
            k++;
        }
        return mat;
    }
    
    public SparseMat fastTranspose(){
        SparseMat mat = new SparseMat();
        mat.row = row;
        mat.column = column;
        mat.size = size;

        mat.mat = new int[size][3];


        int[] total = new int[column];
        
        for(int i=0 ; i< size ; i++){
            total[this.mat[i][1]]+=1;
        }
        int[] index = new int[total.length];
        index[0] = 1;

        for(int i=1;i<index.length;i++){
            index[i] = index[i-1] + total[i-1];
        }

        int loc;
        
        for(int i=0;i<size;i++){
            loc = index[this.mat[i][1]];
            mat.mat[loc-1][0] = this.mat[i][1];
            mat.mat[loc-1][1] = this.mat[i][0];
            mat.mat[loc-1][2] = this.mat[i][2];
            index[this.mat[i][1]] ++;
        }
        


        return mat;
    }

    public void print() {
        System.out.println("\nR  C  V");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf(mat[i][j] + "  ");
            }
            System.out.printf("\n");
        }
        System.out.println("");

    }

}

public class P7 {

    public static SparseMat add(SparseMat m1, SparseMat m2) {
        SparseMat mat = new SparseMat();
        mat.row = m1.row;
        mat.column = m1.column;
        mat.mat = new int[100][3];

        int x = 0, y = 0, z = 0;
        mat.size = 0;

        while (x < m1.size && y < m2.size) {
            if (m1.mat[x][0] == m2.mat[y][0] && m1.mat[x][1] == m2.mat[y][1]) {

                mat.mat[z][0] = m1.mat[x][0];
                mat.mat[z][1] = m1.mat[x][1];
                mat.mat[z][2] = m1.mat[x][2] + m2.mat[y][2];
                mat.size++;
                x++;
                y++;
                z++;
                
            } else if (m1.mat[x][0] == m2.mat[y][0]) {
                if (m1.mat[x][1] < m2.mat[y][1]) {
                    mat.mat[z][0] = m1.mat[x][0];
                    mat.mat[z][1] = m1.mat[x][1];
                    mat.mat[z][2] = m1.mat[x][2];
                    mat.size++;
                    x++;
                    z++;
                    
                } else {
                    mat.mat[z][0] = m2.mat[y][0];
                    mat.mat[z][1] = m2.mat[y][1];
                    mat.mat[z][2] = m2.mat[y][2];
                    mat.size++;
                    y++;
                    z++;
                }
            }
            
            else if (m1.mat[x][0] > m2.mat[y][0]) {
                mat.mat[z][0] = m2.mat[y][0];
                mat.mat[z][1] = m2.mat[y][1];
                mat.mat[z][2] = m2.mat[y][2];
                mat.size++;
                y++;
                z++;
            } else {
                mat.mat[z][0] = m1.mat[x][0];
                mat.mat[z][1] = m1.mat[x][1];
                mat.mat[z][2] = m1.mat[x][2];
                mat.size++;
                z++;
                x++;
                
            }
        }
        
        return mat;
    }
    
    public static void printMat(int[][] mat) {
        System.out.println("\n");
        for (int i = 0; i < mat.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.print("]\n");
        }
    }

    public static int[][] getMat() {

        System.out.print("Enter the no. of Rows : ");
        int row = sc.nextInt();
        System.out.print("Enter the no. of Columns : ");
        int column = sc.nextInt();

        int mat[][] = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Enter the For (" + (i + 1) + " x " + (j + 1) + " ) : ");
                mat[i][j] = sc.nextInt();
            }
        }

        return mat;
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {

        System.out.println("Enter for Mat1 : ");
        int[][] mat1 = getMat();
        System.out.println("Enter for Mat2 : ");
        int[][] mat2 = getMat();

        printMat(mat1);
        printMat(mat2);

        SparseMat m1 = new SparseMat(mat1);
        SparseMat m2 = new SparseMat(mat2);

        m1.print();
        m2.print();

        boolean end = false;

        while (!end) {
            System.out.println("Enter the Operation \n1.add \n2.simple transpose\n3.fast Transpose\n4.Exit");
            int mode = sc.nextInt();
            sc.nextLine();

            switch (mode) {
                case 1:

                    (add(m1, m2)).print();

                    break;
                case 2:

                    m1.simpleTranspose().print();

                    break;
                case 3:

                    m1.fastTranspose().print();

                    break;

                case 4:
                    end = true;
                    break;

                default:
                    break;
            }

        }


    }
}