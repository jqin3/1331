package exam1;

public class Exam {
	public static void main(String[] args) {
		Exam a = new Exam();
		int[] b={1,2,3};
		int x=1;
		int y = x++;
		System.out.print(x);
		System.out.print(y);
		a.contains(b,5);
    }
	public boolean contains(int[] numbers, int n) {
		boolean m = true;
//		for (int i = 0; i < numbers.length - 1; i++) {
		int i = 0;
		while (m){
			if (numbers[i] == n) {
				m = true;
				i--;
				System.out.println(m);
				return m;
			}
		}
		m = false;
		System.out.println(m);
		return m;
	}
}
