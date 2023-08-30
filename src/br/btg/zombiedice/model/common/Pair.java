package br.btg.zombiedice.model.common;

import java.util.Map;

/*+
 * Par (chave(K) e valor(V))
 */
public class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

}
