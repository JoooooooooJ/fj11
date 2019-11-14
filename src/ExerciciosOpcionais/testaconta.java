package ExerciciosOpcionais;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import br.com.caelum.contas.modelo.Conta;

public class testaconta {
	
	public static void main(String args[])	{
		HashSet<Conta> acc = new HashSet<Conta>();
		
		List<String> a = new ArrayList<String>();
		
		Random rand = new Random();
		
		for (int i = 0; i < 10; i++) {
			//acc.add(new Conta(rand.nextInt(10),"Rodolfo"));		
			a.add(Integer.toString(rand.nextInt()));
		}
		
		acc.forEach(item ->{
			System.out.println(item.dadosParaImpressao());
		});
		a.forEach(System.out::println);
		System.out.println("------------------");
		Collections.sort(a, (s1,s2) -> Integer.compare(s1.length(), s2.length()));
		a.forEach(System.out::println);

	}

}
