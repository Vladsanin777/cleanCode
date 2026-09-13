package org.Vladsanin777.cleanCode.Ex4;

import org.Vladsanin777.cleanCode.Ex2.User;

class Ex4 {
    public static void main(String[] args) {

    }
}

public class Server {
    private long m_id = 0;
    private String m_name = null;
    private ArrayList<long> m_sendMessage = new ArrayList<long>;
    private ArrayList<long> m_sendImage = new ArrayList<long>;
    private ArrayList<long> m_addUser = new ArrayList<long>;
    private ArrayList<long> m_deleteMessage = new ArrayList<long>;
    private ArrayList<long> m_deleteImage = new ArrayList<long>;
    private ArrayList<long> m_deleteUser = new ArrayList<long>;
    private ArrayList<long> m_administrator = new ArrayList<long>;
    private ArrayList<long> m_owner = new ArrayList<long>;

    public enum Rule {
        USER, ADMINISTRATOR, OWNER
    }

    public enum Action {
        SEND_MESSAGE, SEND_IMAGE, ADD_USER, DELETE_MESSAGE,
        DELETE_IMAGE, DELETE_USER
    }

    public Server(long id, String name, User owner) {
        this(id, name, owner.getId());
    }

    public Server(long id, String name, long idOwner) {
        m_id = id;
        m_name = name;
        m_owner.add(idOwner);
    }

    public boolean tryAction(Action action, User masterUser, User slaveUser) {
        if (hasPermission(action, masterUser)) {
            sendMessage(slaveUser);
            return true;
        }

        return false;
    }

    public boolean hasAction(Action action, User user) {
        return user.is() && (user.isAdministrator()
                || hasPermission(user, action));
    }

    public boolean hasPermission(User user, Action action) {
        return hasPermission(user, Permission.values()[action.ordinal()]);
    }

    public boolean hasPermission(User user, Permission permission) {
        ArrayList<ArrayList<long>> m_usersIds = switch (permission) {
            case SEND_MESSAGE -> new ArrayList<ArrayList<long>> {
                m_sendMessage, m_administrator, m_owner
            }
            case SEND_IMAGE -> new ArrayList<ArrayList<long>> {
                m_sendImage, m_administrator, m_owner
            }
            case ADD_USER -> new ArrayList<ArrayList<long>> {
                m_addUser, m_administrator, m_owner
            }
            case DELETE_MESAGE -> new ArrayList<ArrayList<long>> {
                m_deleteMessage, m_administrator, m_owner
            }
            case DELETE_IMAGE -> new ArrayList<ArrayList<long>> {
                m_deleteMessage, m_administrator, m_owner
            }
            case DELETE_IMAGE -> new ArrayList<ArrayList<long>> {
                m_deleteImage, m_administrator, m_owner
            }
            case DELETE_USER -> new ArrayList<ArrayList<long>> {
                m_deleteUser, m_administrator, m_owner
            }
            case ADMINISTRATOR -> new ArrayList<ArrayList<long>> {
                m_administrator, m_owner
            }
            case OWNER -> new ArrayList<ArrayList<long>> {
                m_owner
            }
        }

        return hasPermission(user, m_usersIds);
    }

    private boolean hasPermission(User user, ArrayList<ArrayList<long>> ids) {
        long id = user.getIds();
        for (ArrayList<long> subArray : ids) {
            if (subArray.contains(id)) {
                return true;
            }
        }
        return false;
    }

    public Rule getRule() {
        return 
    }
}
