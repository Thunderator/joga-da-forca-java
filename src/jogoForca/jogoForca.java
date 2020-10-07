package jogoForca;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class jogoForca {
	public static void main(String[] args) {
		int erros = 0;
		boolean jogoGanho = false;
		int posicaoPersonagem;
		char letra;
		ArrayList<Character> letrasUsadas = new ArrayList<Character>();
		String personagemSelecionado;
		String[] personagens = { "Conan", "Kull", "Surtur", "Ego", "Sentinela", "Quasar", "Nômade", "Ciclope",
				"Noturno", "Míssil", "Destrutor", "Vulcano", "Polaris", "Vampira", "Colossus", "Gambit", "Fera",
				"Magia", "Tempestade", "Solaris", "Wolverine", "Psylocke", "Jubileu", "Forge", "Bishop", "Anjo",
				"Cable", "Apache", "Shatterstar", "Thor", "Namor", "Justiceiro", "Blade", "Visão", "Groot", "Nova",
				"Coisa", "Manto", "Adaga", "Drax" };

		Random gerador = new Random();
		posicaoPersonagem = gerador.nextInt(personagens.length);
		personagemSelecionado = personagens[posicaoPersonagem].toLowerCase();
		System.out.println(personagens[posicaoPersonagem]); // Diz o personagem
		char[] personagem = personagemSelecionado.toCharArray();

		System.out.println("Sua palavra tem " + personagem.length + " letras");

		char[] impressao = new char[personagem.length];
		Arrays.fill(impressao, '_');

		while (erros < 6 && jogoGanho == false) {

			for (int i = 0; i < personagem.length; i++) {
				System.out.print(impressao[i] + " ");
			}

			letra = JOptionPane.showInputDialog("Digite uma letra: ").toLowerCase().charAt(0);

			if (letrasUsadas.contains(letra)) {
				System.out.println("");
				System.out.println("Você já utilizou esta letra, tente outra");
				System.out.print("Letras já utilizadas: ");
				for (int i = 0; i < letrasUsadas.size(); i++) {
					System.out.print(letrasUsadas.get(i));
					
					if (letrasUsadas.size() -1 > i) {
						System.out.print(", ");						
					}
				}
				System.out.println("");
				continue;
			} else {
				letrasUsadas.add(letra);
			}

			if (personagemSelecionado.indexOf(letra) != -1) {
				for (int i = 0; i < personagem.length; i++) {
					if (personagem[i] == letra) {
						impressao[i] = letra;
					}
				}
				System.out.println("contém");
			} else {
				System.out.println("");
				if (erros == 0)
					System.out.println("   O");
				else if (erros == 1) {
					System.out.println("   O");
					System.out.println("   |");
				} else if (erros == 2) {
					System.out.println("   O");
					System.out.println("   |\\");
				} else if (erros == 3) {
					System.out.println("   O ");
					System.out.println("  /|\\");
				} else if (erros == 4) {
					System.out.println("   O ");
					System.out.println("  /|\\");
					System.out.println("  /");
				} else if (erros == 5) {
					System.out.println("   O ");
					System.out.println("  /|\\");
					System.out.println("  /" + " \\");
				}
				erros++;
			}
			if (String.valueOf(impressao).equals(personagemSelecionado)) {
				jogoGanho = true;
				System.out.println("Você ganhou!");
			}
		}
		if (erros == 6) {
			System.out.println("Você perdeu!");
		}
	}
}