package util;

public class Queue {
    private QueueNode beginning;
    private QueueNode end;

    public Queue() {
        beginning = end = null;
    }

    public boolean isEmpty() {
        return beginning == null;
    }

    public void enqueue(List newList) {
        QueueNode newNode = new QueueNode(newList);

        if(isEmpty()) {
            beginning = end = newNode;
        } else {
            end.setNext(newNode);
            end = newNode;
        }
    }

    public String show() {
        String saida = "";
        QueueNode auxiliar = beginning;
        int counter = 1;

        while(auxiliar != null) {
            saida += "Pedido nº " + counter + "\n" + auxiliar.getList().listAll() + "\n********\n";
            auxiliar = auxiliar.getNext();
            counter++;
        }
        return saida;
    }

    public String peek() {
        if(isEmpty()) {
            return "";
        }
        return beginning.getList().listAll();
    }

    public String dequeue() {
        if(isEmpty()) {
            return "";
        }
        QueueNode auxiliar = beginning;
        beginning = beginning.getNext();
        if(beginning == null) {
            end = null;
        }
        return auxiliar.getList().listAll();
    }
}
