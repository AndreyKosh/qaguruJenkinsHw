This branch for colleagues</br>
If you wanna start you should do:
1) open job in jenkins
2) add string parameters SELENOID_URL and VIDEO_URL with defauld value selenoid.autotests.cloud and https://selenoid.autotests.cloud/video/
3) in gradle task write clean test -DselenoidUrl=${SELENOID_URL} -DvideoUrl=${VIDEO_URL}
4) repository https://github.com/AndreyKosh/qaguruJenkinsHw branch "forColleague"