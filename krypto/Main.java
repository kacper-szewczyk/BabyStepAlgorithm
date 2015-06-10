package krypto;

import java.util.ArrayList;

public class Main
{
	public static Long findReverse(double d, Long b)
	{
		Long u = 1l;
		Long x = 0l;
		Long w = (long) d;
		Long z = b;
		Long buffer;
		Long q2;
		while(w!=0l)
		{
			if(w<z)
			{
				buffer=u;
				u=x;
				x=buffer;
				buffer=w;
				w=z;
				z=buffer;
			}
			q2=w/z;
			u=u-q2*x;
			w=w-q2*z;
		}
		if(z!=1l)
		{
			//System.out.println("Couldn'y find d^(-1)");
			return null;
		}
		if(x<0l)
		{
			x=x+b;
		}
		return x;
	}
	public static void main(String[] args) 
	{
		Long x;
		Long a=3l;
		Long b=693l;
		Long n=1823l;
		ArrayList<Long> powerOfA=new ArrayList<Long>();
		Long m=Math.round(Math.sqrt(n));
		if(m<Math.sqrt(n)) m++;
		for(Long i=0l;i<m;i++)
		{
			powerOfA.add((long) Math.pow(a, i));
		}
		Long reverseA = findReverse(Math.pow(a, m),n);
		Long y = b;
		System.err.println(reverseA);
		for(Long i=0l;i<m;i++)
		{
			
			System.out.println(y);
			for(int j=0;j<m;j++)
			{
				if(powerOfA.get(j)==y) 
				{
					Long result = (i*m+j)%n;
					System.out.println(i+": "+result);
					i=m;
					j=m.intValue();
				}
					
			}
			
			y=(y*reverseA )%n;
			
		}
	}
	
	
}
