import p1.Etree;

class Test
{
    public static void main(String args[])
    {
        String a = "a + b * c - 56 ^ 2 * ( 2 - a ) / 7";
        int arr[] = new int[26];
        arr[0] = 2;
        arr[1] = 1;
        arr[2] = 0;

        Etree t = new Etree();
        if( t.setInfixExpression(a) == false)
            System.out.print("Error");
        
        t.setArray(arr);
        System.out.print(t.Evaluate());
    }
}