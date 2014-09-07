format 76

classinstance 128002 class_ref 128898 // HMC
 name ""  xyz 52 73 2000
classinstance 128130 class_ref 128130 // Hall
 name ""  xyz 22 477 2000
classinstance 128258 class_ref 128258 // Warden
 name ""  xyz 229 76 2000
classinstance 128386 class_ref 129026 // MessManager
 name ""  xyz 228 253 2000
classinstance 128514 class_ref 128514 // Clerk
 name ""  xyz 608 143 2000
classinstance 128642 class_ref 142210 // DailyWorker
 name ""  xyz 593 77 2000
linkcanvas 128770
  from ref 128002 z 2001 to ref 128258
dirscanvas 128898 z 1000 linkcanvas_ref 128770
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "1 create()
11 set_hallCode()" xyz 122 38 3000
linkcanvas 129026
  from ref 128002 z 2001 to point 74 132
  line 129154 z 2001 to ref 128386
dirscanvas 129282 z 1000 linkcanvas_ref 129154
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "2 recruitWorker()
12 set_hallCode()" xyz 143 146 3000
linkcanvas 129410 decenter_end 180
  from ref 128002 z 2001 to point 29 83
  line 129666 z 2001 to ref 128130
dirscanvas 129538 z 1000 linkcanvas_ref 129666
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "3 setupHall()
4 set_status()
5 set_numSingleRoom()
6 set_numDoubleRoom()
7 set_singleRoomRent()
8 set_doubleRoomRent()
9 set_wardenId()
10 set_messManager()" xyz 51 225 3000
linkcanvas 130050
  from ref 128258 z 2001 to point 253 153
  line 130178 z 2001 to ref 128514
dirscanvas 130306 z 1000 linkcanvas_ref 130178
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "13 recruitWorker()
15 set_hallCode()" xyz 387 107 3000
linkcanvas 130434
  from ref 128258 z 2001 to ref 128642
dirscanvas 130562 z 1000 linkcanvas_ref 130434
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "14 giveAttendence()
16 set_hallCode()" xyz 387 40 3000
msgs
  msg operation_ref 154114 // "create()"
    forward ranks 1 "1" dirscanvas_ref 128898
    no_msg
  msg operation_ref 154242 // "recruitWorker()"
    forward ranks 2 "2" dirscanvas_ref 129282
    no_msg
  msg operation_ref 154498 // "setupHall()"
    forward ranks 3 "3" dirscanvas_ref 129538
    no_msg
  msg operation_ref 132098 // "set_status(in value : string) : void"
    forward ranks 4 "4" dirscanvas_ref 129538
    no_msg
  msg operation_ref 130562 // "set_numSingleRoom(in value : int) : void"
    forward ranks 5 "5" dirscanvas_ref 129538
    no_msg
  msg operation_ref 131074 // "set_numDoubleRoom(in value : int) : void"
    forward ranks 6 "6" dirscanvas_ref 129538
    no_msg
  msg operation_ref 132354 // "set_singleRoomRent(in value : int) : void"
    forward ranks 7 "7" dirscanvas_ref 129538
    no_msg
  msg operation_ref 132610 // "set_doubleRoomRent(in value : int) : void"
    forward ranks 8 "8" dirscanvas_ref 129538
    no_msg
  msg operation_ref 157442 // "set_wardenId(in value : string) : void"
    forward ranks 9 "9" dirscanvas_ref 129538
    no_msg
  msg operation_ref 137090 // "set_messManager(in value : string) : void"
    forward ranks 10 "10" dirscanvas_ref 129538
    no_msg
  msg operation_ref 133506 // "set_hallCode(in value : string) : void"
    forward ranks 11 "11" dirscanvas_ref 128898
    no_msg
  msg operation_ref 135810 // "set_hallCode(in value : string) : void"
    forward ranks 12 "12" dirscanvas_ref 129282
    no_msg
  msg operation_ref 154370 // "recruitWorker()"
    forward ranks 13 "13" dirscanvas_ref 130306
    no_msg
  msg operation_ref 152322 // "giveAttendence()"
    forward ranks 14 "14" dirscanvas_ref 130562
    no_msg
  msg operation_ref 135810 // "set_hallCode(in value : string) : void"
    forward ranks 15 "15" dirscanvas_ref 130306
    no_msg
  msg operation_ref 135810 // "set_hallCode(in value : string) : void"
    forward ranks 16 "16" dirscanvas_ref 130562
    no_msg
msgsend
end
