package pMinus1Method;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class Main 
{

	public static void main(String[] args) 
	{
		Long longN = 138277151l;
		//Long longN = 18533588383l;
		Long longB = 3l;
		BigInteger n = new BigInteger(longN.toString());
		BigInteger B = new BigInteger(longB.toString());
		BigInteger k = BigInteger.ONE;
		for(Long i=1l;i<=longB;i++)
		{
			k = k.multiply(new BigInteger(i.toString()));
		}
		Random generator = new Random();
		Long gen = (generator.nextLong()%(longN-3));
		BigInteger a = new BigInteger(gen.toString());
		a = a.add(BigInteger.ONE);
		a = a.add(BigInteger.ONE);
		BigInteger r = BigInteger.ONE;
		for(BigInteger i = BigInteger.ZERO;
				i.compareTo(k)==-1;i = i.add(BigInteger.ONE))
		{
			r = r.multiply(a);
			//System.out.println(r);
		}
		r = r.mod(n);
		//System.out.println(r);
		BigInteger d = gcd((r.subtract(BigInteger.ONE)),n);
		
		while(d.compareTo(BigInteger.ONE)==0 
				|| d.compareTo(n)==0)
		{
			gen = (generator.nextLong()%(longN-3));
			a = new BigInteger(gen.toString());
			a = a.add(BigInteger.ONE);
			a = a.add(BigInteger.ONE);
			r = BigInteger.ONE;
			for(BigInteger i = BigInteger.ZERO;
					i.compareTo(k)==-1;i = i.add(BigInteger.ONE))
			{
				r = r.multiply(a);
			}
			r = r.mod(n);
			d = gcd((r.subtract(BigInteger.ONE)),n);
		}
		System.out.println(d);
	}

	private static BigInteger gcd(BigInteger r, BigInteger n) 
	{
		while(r.compareTo(n)!=0)
		{
			if(r.compareTo(n)==1)
			{
				r=r.subtract(n);
			}
			else
			{
				n=n.subtract(r);
			}
		}
		return r;
	}

}
