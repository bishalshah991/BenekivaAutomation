#!/bin/bash

# Start the VNC server
/usr/bin/vncserver :1 -geometry 1280x800 -depth 24 -localhost no

# Start websockify
/usr/src/python3-websockify/websockify --web /opt/novnc --target-config=/opt/selenium/config.json $VNC_PORT --cert /opt/novnc/self.pem --ssl-only
