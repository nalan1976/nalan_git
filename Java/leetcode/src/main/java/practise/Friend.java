package practise;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class Friend {
    private Collection<Friend> friends;
    private String email;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {
//        throw new UnsupportedOperationException("Waiting to be implemented.");
        //if friend is my direct friend
//        if(this.friends.contains(friend)) return true;

        //depth first
        LinkedList<Friend> list = new LinkedList<>();
        list.add(this);

        while ( !list.isEmpty() ){
            Friend node = list.pop();
            if (node.friends != null && !node.friends.contains(friend)){
                for(Friend f : node.friends){
                    list.push(f);
                }
            }
            else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");
        Friend d = new Friend("D");

        a.addFriendship(b);
        b.addFriendship(c);
        c.addFriendship(d);

        System.out.println(a.canBeConnected(c));
        assertEquals(true, a.canBeConnected(c));

        assertEquals(true, a.canBeConnected(d));

    }
}
