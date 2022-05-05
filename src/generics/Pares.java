package generics;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Pares<C, V> {

	private final Set<Par<C, V>> itens = new HashSet<>();

	public void adicionar(C chave, V valor) {
		if (chave == null)
			return;
		Par<C, V> novaPar = new Par<C, V>(chave, valor);
		if (itens.contains(novaPar)) {
			itens.remove(novaPar);
		}
		itens.add(novaPar);
	}

	public V getValor(C chave) {
		if (chave == null)
			return null;
		Optional<Par<C, V>> parOpicional = itens.stream().filter(par -> chave.equals(par.getChave())).findFirst();
		return parOpicional.isPresent() ? parOpicional.get().getValor() : null;
	}
}
