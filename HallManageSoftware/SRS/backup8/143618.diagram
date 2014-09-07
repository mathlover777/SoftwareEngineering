format 76

classinstance 128002 class_ref 128898 // HMC
 name ""  xyz 459 38 2000
classinstance 128130 class_ref 128130 // Hall
 name ""  xyz 78 37 2000
classinstance 128258 class_ref 128258 // Warden
 name ""  xyz 70 219 2000
classinstance 128386 class_ref 142466 // GrantRequest
 name ""  xyz 440 218 2000
linkcanvas 128514
  from ref 128258 z 2001 to ref 128386
dirscanvas 128642 z 1000 linkcanvas_ref 128514
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "1 set_clerkSalary()
2 set_attendentSalary()
3 get_gardenerSalary()
4 set_attendentCount()
5 set_gardenerCount()
6 set_miscCharges()
7 makeGrant()" xyz 224 112 3000
linkcanvas 129154
  from ref 128002 z 2001 to ref 128130
dirscanvas 129538 z 1000 linkcanvas_ref 129154
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "9 addToSalaryAccount()
10 addToMiscAccount()" xyz 232 66 3000
linkcanvas 129282 decenter_begin 523
  from ref 128386 z 2001 to ref 128002
dirscanvas 129410 z 1000 linkcanvas_ref 129282
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  backward_label "8 viewGrant()" xyz 499 134 3000
msgs
  msg operation_ref 155906 // "set_clerkSalary(in value : int) : void"
    forward ranks 1 "1" dirscanvas_ref 128642
    no_msg
  msg operation_ref 156162 // "set_attendentSalary(in value : int) : void"
    forward ranks 2 "2" dirscanvas_ref 128642
    no_msg
  msg operation_ref 156290 // "get_gardenerSalary()"
    forward ranks 3 "3" dirscanvas_ref 128642
    no_msg
  msg operation_ref 156930 // "set_attendentCount(in value : int) : void"
    forward ranks 4 "4" dirscanvas_ref 128642
    no_msg
  msg operation_ref 157186 // "set_gardenerCount(in value : int) : void"
    forward ranks 5 "5" dirscanvas_ref 128642
    no_msg
  msg operation_ref 156674 // "set_miscCharges(in value : int) : void"
    forward ranks 6 "6" dirscanvas_ref 128642
    no_msg
  msg operation_ref 157826 // "makeGrant()"
    forward ranks 7 "7" dirscanvas_ref 128642
    no_msg
  msg operation_ref 157954 // "viewGrant()"
    backward ranks 8 "8" dirscanvas_ref 129410
    no_msg
  msg operation_ref 158082 // "addToSalaryAccount(in amount : int)"
    forward ranks 9 "9" dirscanvas_ref 129538
    no_msg
  msg operation_ref 158210 // "addToMiscAccount(in amount : int)"
    forward ranks 10 "10" dirscanvas_ref 129538
    no_msg
msgsend
end
