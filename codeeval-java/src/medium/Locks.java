package medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cedric on 5/9/2016.
 */
public class Locks {

    public static class Door {
        private int id = 0;
        private int state = 0;

        public Door(int id) {
            this.id = id;
        }

        public void close() {
            lock();
        }

        public void toggle() {
            if (isUnlocked()) {
                lock();
            } else {
                unlock();
            }
        }

        public boolean isUnlocked() {
            return state == 0;
        }

        public void lock() {
            state = 1;
        }

        public void unlock() {
            state = 0;
        }

        @Override
        public String toString() {
            return "Door{" +
                    "id=" + id +
                    ", state=" + state +
                    '}';
        }
    }

    public static class Corridor {
        private List<Door> doors = new LinkedList();

        public Corridor(int length) {
            for (int i = 0; i < length; i++) {
                doors.add(new Door(i));
            }
        }

        public List<Door> getDoors() {
            return doors;
        }

        public int getDoorUnlockedStatus() {
            int count = 0;
            for (Door door : doors) {
                if (door.isUnlocked()) {
                    count++;
                }
            }

            return count;
        }
    }

    public static class Guard {
        private Corridor corridor;
        private int iterations;

        public Guard(Corridor corridor, int iterations) {
            this.corridor = corridor;
            this.iterations = iterations;
        }

        public void beats() {
            for (int i = 0; i < iterations - 1; i++) {
                beat();
            }

            Door lastDoor = corridor.getDoors().get(corridor.getDoors().size() - 1);
            lastDoor.toggle();
        }

        private void beat() {
            for (int i = 1; i < corridor.getDoors().size(); i = i + 2) {
                corridor.getDoors().get(i).lock();
            }

            for (int i = 2; i < corridor.getDoors().size(); i = i + 3) {
                corridor.getDoors().get(i).toggle();
            }
        }

    }


    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                String[] todo = line.split(" ");
                int doors = Integer.parseInt(todo[0]);
                int iterations = Integer.parseInt(todo[1]);
                Corridor corridor = new Corridor(doors);

                Guard guard = new Guard(corridor, iterations);
                guard.beats();

                int doorUnlockedStatus = corridor.getDoorUnlockedStatus();
                System.out.println(doorUnlockedStatus);
            }
        }
    }


}
