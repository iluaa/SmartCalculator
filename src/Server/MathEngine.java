package Server;

import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.CopyOnWriteArrayList;

public class MathEngine  {
    //public String operation = CalcWindow.inputField.getText();
    //public double acc;
    String delimiters = "+-*/()";
    public MathEngine(){
        //parserString(operation);
    }

    public List<String> parserString(String str)
    {
        List<String> operationParts = new CopyOnWriteArrayList<>();

        StringTokenizer parts = new StringTokenizer(str,delimiters , true);


        while(parts.hasMoreTokens())
        {
            operationParts.add(parts.nextToken());
        }
        //System.out.println(operationParts);
        return operationParts;
    }


    public String makeMath(List<String> list) {
        for (String ss: list)
        {
            if (ss.equals("*") || ss.equals("/"))
            {
                for (int i=0; i < list.size(); i++)
                {
                    Double number;
                    if (list.get(i).equals("*"))
                    {
                        number = mult(Double.parseDouble(list.get(i-1)), Double.parseDouble(list.get(i+1)));
                        list.set(i, number.toString());
                        list.remove(i+1); list.remove(i-1);
                    }
                    else if (list.get(i).equals("/"))
                    {
                        number = div(Double.parseDouble(list.get(i-1)), Double.parseDouble(list.get(i+1)));
                        list.set(i, number.toString());
                        list.remove(i+1); list.remove(i-1);
                    }
                }
            }
        }
        //System.out.println(list);
        for (String ss: list)
        {
            if (ss.equals("+") || ss.equals("-"))
            {
                for (int i=0; i < list.size(); i++)
                {
                    Double number;
                    if (list.get(i).equals("+"))
                    {
                        number = plus(Double.parseDouble(list.get(i-1)), Double.parseDouble(list.get(i+1)));
                        list.set(i, number.toString());
                        list.remove(i+1); list.remove(i-1);
                    }
                    else if (list.get(i).equals("-"))
                    {
                        number = minus(Double.parseDouble(list.get(i-1)), Double.parseDouble(list.get(i+1)));
                        list.set(i, number.toString());
                        list.remove(i+1); list.remove(i-1);
                    }
                }
            }
        }
        return list.get(0);
    }

    double plus(double a, double b)
    {
        return a+b;
    }
    double minus(double a, double b)
    {
        return a-b;
    }
    double mult(double a, double b)
    {
        return a*b;
    }
    double div(double a, double b)
    {
        return a/b;
    }
}
