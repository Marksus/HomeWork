package a15genome;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Genome {

	public static int GENOME_SIZE = 1_000_000;
	public static char[] letters = { 'A', 'C', 'G', 'T' };

	char[] sequence;

	public void generateSequence() {
		Random random = new Random();
		sequence = new char[GENOME_SIZE];

		for (int i = 0; i < sequence.length; i++) {
			sequence[i] = letters[random.nextInt(letters.length)];
		}

	}

	public void searchDuplicatesBruteForce(char[] data, int M) {
		for (int i = 0; i < data.length - M + 1; i++) {
			for (int j = i + 1; j < data.length - M + 1; j++) {
				// System.out.println(data[i] + "," + data[j]);
				int k = i;
				int m = j;
				int n = 0;
				while (data[k++] == data[m++] && ++n < M) {
				}
				if (n == M) {
					System.out.println("Match at " + i + " and " + j);
				}
			}
		}
	}

	public void searchDuplicatesSorting(char[] data, int M) {
		List<String> words = new LinkedList<>();

		System.out.println("start");

		for (int i = 0; i < data.length - M + 1; i++) {
			String word = new String(data, i, M);
			words.add(word);
			if (i % 1_000_000 == 0) {
				System.out.println(i);
			}
		}

		System.out.println("sort");

		Set<String> set = new HashSet<>();
		List<String> unsortedWords = new LinkedList<>();

		Collections.copy(words, unsortedWords);
		Collections.sort(words);

		System.out.println("search");
		Iterator<String> it = words.iterator();
		String last = "";
		while (it.hasNext()) {
			String word = it.next();
			if (word.equals(last)) {
				set.add(word);
			}
			last = word;
		}
		for (String word : set) {
			System.out.print(word + " was founded on ");
			for (int i = 0; i < data.length - M + 1; i++) {
				if (word.equals(new String(data, i, M)))
					System.out.print(i + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {

		Genome genome = new Genome();

		genome.searchDuplicatesBruteForce(new char[] { 'A', 'A', 'C', 'T', 'A', 'A', 'C' }, 3);

		System.out.println("Generating");
		genome.generateSequence();
		// genome.searchDuplicatesBruteForce(genome.sequence, 10);

		System.out.println("Searching");
		genome.searchDuplicatesSorting(genome.sequence, 10);

	}

}