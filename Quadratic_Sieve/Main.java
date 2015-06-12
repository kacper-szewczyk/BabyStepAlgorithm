package Quadratic_Sieve;

import java.math.BigInteger;
import java.util.ArrayList;

public class Main 
{

	public static void main(String[] args) 
	{
		BigInteger n = new BigInteger("11111");
		BigInteger m = squareRoot(n).subtract(BigInteger.ONE);
		ArrayList<BigInteger> a = new ArrayList<BigInteger>();
		ArrayList<BigInteger> b = new ArrayList<BigInteger>();
		BigInteger temp;
		BigInteger end = BigInteger.ONE.add(BigInteger.ONE);
		for(BigInteger x=BigInteger.ZERO;x.compareTo(end)<=0;
				x=x.add(BigInteger.ONE))
		{
			a.add(x.add(m));
			temp = a.get(x.intValue()).multiply(a.get(x.intValue()))
					.subtract(n);
			if(temp.compareTo(BigInteger.ZERO)<0)
			{
				temp=temp.add(n);
			}
			b.add(temp);
		}
		BigInteger productA = BigInteger.ONE;
		BigInteger productB = BigInteger.ONE;
		for(int i=0;i<=end.intValue();i++)
		{
			productA = productA.multiply(new BigInteger(a.get(i).toString()));
			productB = productB.multiply(new BigInteger(b.get(i).toString()));
		}
		//System.out.println(productA+ " "+productB);
		BigInteger sqrtA = squareRoot(productA);
		BigInteger c = squareRoot(productB);
		System.out.println(sqrtA+" "+c);
		BigInteger result = gcd(sqrtA.add(c),n);
		System.out.println(result);
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


	private static BigInteger squareRoot(BigInteger a) 
	{
		BigInteger candidate = BigInteger.ONE;
		BigInteger product = candidate.multiply(candidate);
		while(product.compareTo(a)<0)
		{
			candidate = candidate.add(BigInteger.ONE);
			product = candidate.multiply(candidate);
			//System.out.println(product+ " " + a);
		}
		return candidate;
	}

}
