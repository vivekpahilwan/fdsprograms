#include <iostream>
#include <string.h>
using namespace std;

class mat
{
public:
    int *matrix;
    int x;
    int y;

    mat(int x, int y)
    {
        this->x = x;
        this->y = y;
        this->matrix = new int[x * y]();
    }
    void print()
    {
        cout << "\n";
        for (int i = 0; i < x; i++)
        {
            cout << "[ ";
            for (int j = 0; j < y; j++)
            {
                cout << *(matrix + j + i * y) << " "; // Corrected indexing
            }
            cout << "]\n";
        }
    }

    void set()
    {
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                cout << "Enter the Element " << i + 1 << "x" << j + 1 << " : ";
                cin >> *(matrix + j + i * y);
            }
        }
    }

    mat transpose()
    {
        mat m(y, x);
        for (int i = 0; i < y; i++)
        {
            for (int j = 0; j < x; j++)
            {
                *(m.matrix + j + i * y) = *(matrix + j * x + i);
            }
        }
        return m;
    }
};

mat add(mat m1, mat m2)
{
    int x = m1.x, y = m1.y;
    mat m(x, y);
    for (int i = 0; i < x; i++)
    {
        for (int j = 0; j < y; j++)
        {
            *(m.matrix + j + i * y) = *(m1.matrix + j + i * y) + *(m2.matrix + j + i * y);
        }
    }
    return m;
}

mat subtract(mat m1, mat m2)
{
    int x = m1.x, y = m1.y;
    mat m(x, y);
    for (int i = 0; i < x; i++)
    {
        for (int j = 0; j < y; j++)
        {
            *(m.matrix + j + i * y) = *(m1.matrix + j + i * y) - *(m2.matrix + j + i * y);
        }
    }
    return m;
}

mat takeDimensions(string str)
{
    int x, y;
    cout << "Enter the no. of Rows for " << str << " : ";
    cin >> x;
    cout << "Enter the no. of columns for " << str << " : ";
    cin >> y;

    mat m(x, y);
    cout << "For " << str << " : \n";
    m.set();

    return m;
}

mat multiply(mat m1, mat m2)
{
    int x1 = m1.x, y1 = m1.y;
    int x2 = m2.x, y2 = m2.y;
    mat m(x1, y2);

    if (y1 != x2)
    {
        return m;
    }

    for (int i = 0; i < x1; i++)
    {
        for (int j = 0; j < y2; j++)
        {
            for (int k = 0; k < y1; k++)
            {
                *(m.matrix + j + i * y2) += *(m1.matrix + k + i * y1) * *(m2.matrix + j + k * y2);
            }
        }
    }
    return m;
}

int main()
{
    mat m1 = takeDimensions("mat1");
    mat m2 = takeDimensions("mat2");

    bool end = false;
    int inp, mat;
    while (!end)
    {
        cout << "Enter the Operation\n1.print\n2.transpose\n3.add\n4.subtract\n5.multiply\n6.Exit\n";
        cin >> inp;
        switch (inp)
        {
        case 1:
            cout << "1.mat1 / 2.mat2 ? : ";
            cin >> mat;
            if (mat == 1)
            {
                m1.print();
                break;
            }
            m2.print();
            break;
        case 2:
            cout << "1.mat1 / 2.mat2 ? : ";
            cin >> mat;
            if (mat == 1)
            {
                m1.transpose().print();
                break;
            }
            m2.transpose().print();
            break;
        case 3:
            add(m1, m2).print();
            break;
        case 4:
            subtract(m1, m2).print();
            break;
        case 5:
            multiply(m1, m2).print();
            break;
        case 6:
            end = true;
            break;
        default:
            cout << "Try Valid Input\n";
            break;
        }
    }

    return 0;
}