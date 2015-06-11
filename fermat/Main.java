package fermat;

public class Main {

	public static void main(String[] args) 
	{
		int n = 13199;
		boolean test = true;
		int x = 1;
		int y = 1;
		int result = 0;
		while(test)
		{
			result =x*x - y*y;
			if(result < n)
				x++;
			if(result > n)
				y++;
			if(result == n)
				test = false;
			System.out.println("result = "+ result +" x = "+ x + " y = "+ y);
		}
		System.out.println("n = "+ n);
		System.out.println("x = "+ x);
		System.out.println("y = "+ y);
		System.out.println("x*x-y*y = "+ result);

	}

}
