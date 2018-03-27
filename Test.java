import p1.Etree;

class Test
{
    public static void main(String args[])
    {
        String a = "a + b * c - 56 ^ 2 * ( 2 - a ) / 7";/*
        a += " " + "b";
        System.out.print(a);*/
        Etree b = new Etree();
        boolean x = b.setInfixExpression(a);
        if(x)
        	System.out.print(b.getPostfix());
        else
        	System.out.print("Error");
    }
}