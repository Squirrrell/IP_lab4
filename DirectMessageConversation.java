import java.util.ArrayList;
import java.util.List;

public class DirectMessageConversation {
    // Contor pentru a genera ID-uri unice pentru conversații
    private static int conversationCounter = 0;

    // Atributele clasei
    private int conversationId;
    private List<String> participants;
    private List<Message> messages;

    // Clasa internă care modelează un mesaj
    private static class Message {
        private String sender;
        private String content;
        private String timestamp; // Într-o implementare reală s-ar folosi un obiect de tip Date

        public Message(String sender, String content, String timestamp) {
            this.sender = sender;
            this.content = content;
            this.timestamp = timestamp;
        }

        @Override
        public String toString() {
            return "[" + timestamp + "] " + sender + ": " + content;
        }
    }

    // Constructorul pentru o conversație de mesagerie directă
    public DirectMessageConversation(List<String> initialParticipants) {
        conversationCounter++;
        this.conversationId = conversationCounter;
        this.participants = new ArrayList<>(initialParticipants);
        this.messages = new ArrayList<>();
    }

    // Metodă pentru a adăuga un participant la conversație
    public void addParticipant(String participant) {
        if (!participants.contains(participant)) {
            participants.add(participant);
            System.out.println(participant + " a fost adăugat în conversația " + conversationId);
        } else {
            System.out.println(participant + " este deja participant.");
        }
    }

    // Metodă pentru a elimina un participant din conversație
    public void removeParticipant(String participant) {
        if (participants.contains(participant)) {
            participants.remove(participant);
            System.out.println(participant + " a fost eliminat din conversația " + conversationId);
        } else {
            System.out.println(participant + " nu face parte din conversație.");
        }
    }

    // Metodă pentru trimiterea unui mesaj de către un participant
    public void sendMessage(String sender, String content, String timestamp) {
        if (!participants.contains(sender)) {
            System.out.println("Eroare: " + sender + " nu este participant în conversația " + conversationId);
            return;
        }
        Message message = new Message(sender, content, timestamp);
        messages.add(message);
        System.out.println("Mesaj trimis de " + sender);
    }

    // Metodă pentru afișarea conversației
    public void displayConversation() {
        System.out.println("Conversația ID: " + conversationId);
        System.out.println("Participanți: " + participants);
        System.out.println("Mesaje:");
        for (Message message : messages) {
            System.out.println(message);
        }
    }

    // Metoda main pentru testarea funcționalităților clasei
    public static void main(String[] args) {
        // Inițial se creează o conversație cu doi participanți
        List<String> initialParticipants = new ArrayList<>();
        initialParticipants.add("alice");
        initialParticipants.add("bob");
        DirectMessageConversation conversation = new DirectMessageConversation(initialParticipants);

        // Trimiterea de mesaje de către participanți
        conversation.sendMessage("alice", "Salut Bob, ce mai faci?", "2025-03-17 10:00");
        conversation.sendMessage("bob", "Salut Alice, sunt bine! Tu?", "2025-03-17 10:02");

        // Încercare de trimitere a unui mesaj de către un utilizator neparticipativ
        conversation.sendMessage("charlie", "Bună, pot mă alătura?", "2025-03-17 10:05");

        // Adăugarea unui nou participant și trimiterea unui mesaj
        conversation.addParticipant("charlie");
        conversation.sendMessage("charlie", "Acum pot participa! Salut tuturor!", "2025-03-17 10:07");

        // Eliminarea unui participant
        conversation.removeParticipant("bob");

        // Afișarea întregii conversații
        conversation.displayConversation();
    }
}