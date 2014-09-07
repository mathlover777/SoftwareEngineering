format 76

classinstance 128002 class_ref 128002 // Student
 name ""  xyz 59 158 2000
classinstance 128130 class_ref 128130 // Hall
 name ""  xyz 346 60 2000
classinstance 128258 class_ref 129154 // Printer
 name ""  xyz 341 279 2000
classinstance 130050 class_ref 128898 // HMC
 name ""  xyz 62 288 2000
selflinkcanvas 128386 classinstance_ref 128002 // :Student
  xy 84 157
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "2 get_messCharge()" xyz 35 126 3000
linkcanvas 128514
  from ref 128002 z 2001 to ref 128130
dirscanvas 128642 z 1000 linkcanvas_ref 128514
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "3 get_amenityCharge()
5 addToRentAccount()
6 addToMessAccount()
7 addToAmenityAccount()" xyz 147 43 3000
linkcanvas 128770
  from ref 128002 z 2001 to point 10 168
  line 128898 z 2001 to point 10 228
  line 129026 z 2001 to point 82 228
  line 129282 z 2001 to ref 128002
dirscanvas 129154 z 1000 linkcanvas_ref 128898
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "4 get_roomRent()" xyz 30 194 3000
linkcanvas 129410
  from ref 128002 z 2001 to ref 128258
dirscanvas 129538 z 1000 linkcanvas_ref 129410
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "8 printPaymentReceipt()" xyz 179 196 3000
selflinkcanvas 130178 classinstance_ref 130050 // :HMC
  xy 87 296
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "1 activatePaymentLink()" xyz 38 256 3000
msgs
  msg operation_ref 166530 // "activatePaymentLink()"
    forward ranks 1 "1" selflinkcanvas_ref 130178
    no_msg
  msg operation_ref 153090 // "get_messCharge() : int"
    forward ranks 2 "2" selflinkcanvas_ref 128386
    no_msg
  msg operation_ref 158978 // "get_amenityCharge() : int"
    forward ranks 3 "3" dirscanvas_ref 128642
    no_msg
  msg operation_ref 159618 // "get_roomRent() : int"
    forward ranks 4 "4" dirscanvas_ref 129154
    msgs
      msg operation_ref 159234 // "addToRentAccount(in amount : int)"
	forward ranks 5 "4.1" dirscanvas_ref 128642
	no_msg
    msgsend
  msg operation_ref 145026 // "addToMessAccount(in amount : int)"
    forward ranks 6 "5" dirscanvas_ref 128642
    no_msg
  msg operation_ref 145154 // "addToAmenityAccount(in amount : int)"
    forward ranks 7 "6" dirscanvas_ref 128642
    no_msg
  msg operation_ref 159490 // "printPaymentReceipt(in amount : int, in account : string)"
    forward ranks 8 "7" dirscanvas_ref 129538
    no_msg
msgsend
end
