#include <termios.h>
#include <unistd.h>

// https://www.man7.org/linux/man-pages/man3/termios.3.html
// https://sourceware.org/git/?p=glibc.git;a=blob;f=bits/termios.h;h=798012cb8ebcd2a9b11ca2de998a136431d41999;hb=HEAD
// https://elixir.bootlin.com/glibc/glibc-2.41.9000/source/termios/cfmakeraw.c

void cfmakeraw(struct termios *t) {
    t->c_iflag &= ~(IGNBRK|BRKINT|PARMRK|ISTRIP|INLCR|IGNCR|ICRNL|IXON);
    t->c_oflag &= ~OPOST;
    t->c_lflag &= ~(ECHO|ECHONL|ICANON|ISIG|IEXTEN);
    t->c_cflag &= ~(CSIZE|PARENB);
    t->c_cflag |= CS8;
    t->c_cc[VMIN] = 1;		/* read returns when one char is available.  */
    t->c_cc[VTIME] = 0;
}
