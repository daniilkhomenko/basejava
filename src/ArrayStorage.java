/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        int count = 0;
        while (storage[count] != null) {
            count++;
        }
        storage[count] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int size = size();

        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {

                //shifting all elements to the left
                for (int j = i+1; j < size; j++) {
                    storage[j-1] = storage[j];
                }
                storage[size-1] = null;
                return;
            } else {
                System.out.println("Nothing to delete");
            }
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] arrayForOutput = new Resume[size()];

        for (int i = 0; i < size(); i++) {
            arrayForOutput[i] = storage[i];
        }
        return arrayForOutput;
    }

    int size() {
        int count = 0;
        for (Resume r : storage) {
            if (r != null) {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }
}
