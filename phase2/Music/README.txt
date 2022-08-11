--First time setup--
create a folder named "songs" and put any mp3 files you'd like to listen to in that folder.
the songs folder may only contain mp3 files themselves, and not folders containing mp3 files.

--Login menu commands--
login <username> <password>
    login to the account with the given username and password

create <username> <password>
    create a new account with the given username and password

--Main menu commands--
history
    see the login history of the account that's currently logged in

logout
    log out of the current account, returning to the login menu, whilst stopping any music playback

newadmin <username> <password>
    (ADMIN COMMAND) create a new admin account with the given username and password

delete <username>
    (ADMIN COMMAND) delete the account with the given username

allsongs
    display all songs stored in the songs folder

--Music related commands--
play
    plays the currently displayed playlist from beginning to end

pause
    pauses the music

forward
    go forward one song

backward
    go back one song

shuffle
    toggle shuffle on/off

repeat
    toggle repeat on/off

--Global commands--
exit
    exits the program

mainmenu
    (usable anywhere except the login menu) returns you to the main menu