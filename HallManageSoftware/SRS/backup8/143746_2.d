format 76

classinstance 128002 class_ref 128002 // Student
 name ""  xyz 14 59 2000
classinstance 128130 class_ref 128258 // Warden
 name ""  xyz 192 223 2000
classinstance 128258 class_ref 128898 // HMC
 name ""  xyz 523 59 2000
classinstance 128386 class_ref 142338 // Complaint
 name ""  xyz 191 58 2000
classinstance 128514 class_ref 128130 // Hall
 name ""  xyz 522 337 2000
classinstance 128642 class_ref 129154 // Printer
 name ""  xyz 193 335 2000
linkcanvas 128770
  from ref 128002 z 2001 to ref 128386
dirscanvas 128898 z 1000 linkcanvas_ref 128770
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "1 setupComplaint()
10 [if satisfied]removeComplaint()" xyz 47 22 3000
linkcanvas 129026 decenter_begin 546
  from ref 128130 z 2001 to ref 128386
dirscanvas 129154 z 1000 linkcanvas_ref 129026
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "2 viewComplaint()
3 postATR()
4 forwardToHMC()
9 postATR()" xyz 110 124 3000
linkcanvas 129282
  from ref 128258 z 2001 to ref 128386
dirscanvas 129410 z 1000 linkcanvas_ref 129282
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "5 viewComplaint()" xyz 342 89 3000
linkcanvas 129794
  from ref 128258 z 2001 to ref 128514
dirscanvas 129922 z 1000 linkcanvas_ref 129794
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "6 [if repair money is required]addToRepairAccount()" xyz 566 204 3000
linkcanvas 130050
  from ref 128130 z 2001 to point 496 232
  line 130562 z 2001 to point 496 345
  line 130690 z 2001 to ref 128514
dirscanvas 130178 z 1000 linkcanvas_ref 130050
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "7 [if repair money paid]payFromReapirAccount()" xyz 256 203 3000
linkcanvas 130306
  from ref 128130 z 2001 to ref 128642
dirscanvas 130818 z 1000 linkcanvas_ref 130306
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "8 [if repair money paid]issueCheck()" xyz 236 285 3000
msgs
  msg operation_ref 155010 // "setupComplaint(in message : string)"
    forward ranks 1 "1" dirscanvas_ref 128898
    no_msg
  msg operation_ref 155138 // "viewComplaint()"
    forward ranks 2 "2" dirscanvas_ref 129154
    no_msg
  msg operation_ref 155266 // "postATR()"
    forward ranks 3 "3" dirscanvas_ref 129154
    no_msg
  msg operation_ref 158594 // "forwardToHMC()"
    forward ranks 4 "4" dirscanvas_ref 129154
    no_msg
  msg operation_ref 155138 // "viewComplaint()"
    forward ranks 5 "5" dirscanvas_ref 129410
    no_msg
  explicitmsg "[if repair money is required]addToRepairAccount()"
    forward ranks 6 "6" dirscanvas_ref 129922
    no_msg
  explicitmsg "[if repair money paid]payFromReapirAccount()"
    forward ranks 7 "7" dirscanvas_ref 130178
    no_msg
  explicitmsg "[if repair money paid]issueCheck()"
    forward ranks 8 "8" dirscanvas_ref 130818
    no_msg
  msg operation_ref 155266 // "postATR()"
    forward ranks 9 "9" dirscanvas_ref 129154
    no_msg
  explicitmsg "[if satisfied]removeComplaint()"
    forward ranks 10 "10" dirscanvas_ref 128898
    no_msg
msgsend
end
