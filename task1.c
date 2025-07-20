#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define INITIAL_CAPACITY 2
#define MAX_TITLE_LENGTH 100

char **songs = NULL;
int top = -1;
int capacity = 0;

void initPlaylist() {
    capacity = INITIAL_CAPACITY;
    songs = malloc(capacity * sizeof(char *));
}

void resizePlaylist() {
    capacity *= 2;
    songs = realloc(songs, capacity * sizeof(char *));
}

void push(const char *title) {
    if (songs == NULL) {
        initPlaylist();
    }
    if (top + 1 == capacity) {
        resizePlaylist();
    }
    top++;
    songs[top] = malloc(strlen(title) + 1);
    strcpy(songs[top], title);
    printf("Added: %s\n", songs[top]);
}

void pop() {
    if (top == -1) {
        printf("No song to remove.\n");
        return;
    }
    printf("Removed: %s\n", songs[top]);
    free(songs[top]);
    top--;
}

void current() {
    if (top == -1)
        printf("No song is playing.\n");
    else
        printf("Now Playing: %s\n", songs[top]);
}

void showPlaylist() {
    if (top == -1) {
        printf("Playlist is empty.\n");
        return;
    }
    printf("Playlist:\n");
    for (int i = top; i >= 0; i--) {
        printf("%d. %s\n", top - i + 1, songs[i]);
    }
}

void cleanup() {
    for (int i = 0; i <= top; i++) {
        free(songs[i]);
    }
    free(songs);
}

int main() {
    int choice;
    char song[MAX_TITLE_LENGTH];

    while (1) {
        printf("\n1. Add Song\n2. Remove Song\n3. Current Song\n4. Show Playlist\n5. Exit\nChoice: ");
        scanf("%d", &choice);
        getchar();

        if (choice == 1) {
            printf("Enter song title: ");
            fgets(song, MAX_TITLE_LENGTH, stdin);
            song[strcspn(song, "\n")] = '\0';
            push(song);
        } else if (choice == 2) pop();
        else if (choice == 3) current();
        else if (choice == 4) showPlaylist();
        else if (choice == 5) {
            cleanup();
            printf("Exiting.\n");
            break;
        } else {
            printf("Invalid choice. Try again.\n");
        }
    }
    return 0;
}
