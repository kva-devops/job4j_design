package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    public boolean isBinary() {
        return findByPredicate((val) -> val.children.size() > 2).isEmpty();
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> optParent = findBy(parent);
        Optional<Node<E>> optChild = findBy(child);
        if (optParent.isPresent() && optChild.isEmpty()) {
            optParent.get().children.add(new Node<>(child));
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(val -> val.value.equals(value));
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
