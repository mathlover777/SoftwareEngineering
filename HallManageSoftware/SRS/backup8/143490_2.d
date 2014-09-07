format 76

classinstance 128002 class_ref 128002 // Student
 name ""  xyz 41 185 2000
classinstance 128258 class_ref 128898 // HMC
 name ""  xyz 41 40 2000
classinstance 128386 class_ref 128130 // Hall
 name ""  xyz 430 45 2000
classinstance 128514 class_ref 129154 // Printer
 name ""  xyz 444 128 2000
classinstance 128642 class_ref 129026 // MessManager
 name ""  xyz 306 184 2000
linkcanvas 128770
  from ref 128258 z 2001 to ref 128002
linkcanvas 128898 decenter_begin 652
  from ref 128258 z 2001 to ref 128386
dirscanvas 130178 z 1000 linkcanvas_ref 128898
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "2 addStudentToList()" xyz 209 25 3000
linkcanvas 129026
  from ref 128258 z 2001 to ref 128002
dirscanvas 129666 z 1000 linkcanvas_ref 129026
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "1 allotRoom()
3 set_roomRent()" xyz 83 111 3000
linkcanvas 129154
  from ref 128258 z 2001 to ref 128002
linkcanvas 130306 decenter_end 652
  from ref 128258 z 2001 to point 237 142
  line 130562 z 2001 to ref 128514
dirscanvas 130434 z 1000 linkcanvas_ref 130306
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "4 issueAdmissionLetterToStudent()" xyz 94 71 3000
linkcanvas 130690
  from ref 128642 z 2001 to ref 128002
dirscanvas 130818 z 1000 linkcanvas_ref 130690
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "5 set_messCharge()" xyz 148 215 3000
msgs
  msg operation_ref 153986 // "allotRoom()"
    forward ranks 1 "1" dirscanvas_ref 129666
    no_msg
  msg operation_ref 157698 // "addStudentToList(in name : string, in id : string, in roomNo : string)"
    forward ranks 2 "2" dirscanvas_ref 130178
    no_msg
  msg operation_ref 159746 // "set_roomRent(in value : int) : void"
    forward ranks 3 "3" dirscanvas_ref 129666
    no_msg
  msg operation_ref 159874 // "issueAdmissionLetterToStudent(in name : string, in id : string, in hallName : string, in roomNo : string)"
    forward ranks 4 "4" dirscanvas_ref 130434
    no_msg
  msg operation_ref 153218 // "set_messCharge(in value : int) : void"
    forward ranks 5 "5" dirscanvas_ref 130818
    no_msg
msgsend
end
