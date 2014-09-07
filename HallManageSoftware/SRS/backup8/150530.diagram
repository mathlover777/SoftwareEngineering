format 76

classinstance 128002 class_ref 128130 // Hall
 name ""  xyz 100 66 2000
classinstance 128130 class_ref 128258 // Warden
 name ""  xyz 291 196 2000
classinstance 128258 class_ref 129026 // MessManager
 name ""  xyz 659 76 2000
classinstance 128386 class_ref 128514 // Clerk
 name ""  xyz 54 316 2000
classinstance 128642 class_ref 129154 // Printer
 name ""  xyz 667 318 2000
classinstance 128770 class_ref 142210 // DailyWorker
 name ""  xyz 281 317 2000
linkcanvas 128898
  from ref 128386 z 2001 to ref 128770
dirscanvas 129026 z 1000 linkcanvas_ref 128898
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "1 giveAttendence()" xyz 145 297 3000
linkcanvas 129282
  from ref 128130 z 2001 to ref 128770
dirscanvas 129410 z 1000 linkcanvas_ref 129282
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "2 getTotalAttendence()
6 paySalary()" xyz 337 255 3000
linkcanvas 129538
  from ref 128130 z 2001 to ref 128642
dirscanvas 129666 z 1000 linkcanvas_ref 129538
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "3 generateSalaryList()
5 issueCheck()
10 issueCheck()
13 issueCheck()
14 printAccountStatement()" xyz 455 181 3000
linkcanvas 129794
  from ref 128130 z 2001 to point 316 75
  line 130434 z 2001 to ref 128002
dirscanvas 129922 z 1000 linkcanvas_ref 129794
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "4 payFromSalaryAccount()
9 payFromMessAccount()
11 payFromAmenityAccount()
12 payFromMiscAccount()" xyz 155 108 3000
linkcanvas 130050
  from ref 128130 z 2001 to point 76 207
  line 130306 z 2001 to ref 128386
dirscanvas 130178 z 1000 linkcanvas_ref 130050
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "7 paySalary()" xyz 152 226 3000
linkcanvas 130562
  from ref 128130 z 2001 to ref 128258
dirscanvas 130690 z 1000 linkcanvas_ref 130562
  show_full_operations_definition default show_hierarchical_rank default drawing_language default show_msg_context default
  forward_label "8 computeMonthlyBill()" xyz 439 118 3000
msgs
  msg operation_ref 152322 // "giveAttendence()"
    forward ranks 1 "1" dirscanvas_ref 129026
    no_msg
  msg operation_ref 152450 // "getTotalAttendence() : int"
    forward ranks 2 "2" dirscanvas_ref 129410
    no_msg
  msg operation_ref 153730 // "generateSalaryList()"
    forward ranks 3 "3" dirscanvas_ref 129666
    no_msg
  msg operation_ref 145794 // "payFromSalaryAccount(in amount : int, in code : string)"
    forward ranks 4 "4" dirscanvas_ref 129922
    no_msg
  msg operation_ref 138498 // "issueCheck(in name : string, in amount : int, in hallCode : string)"
    forward ranks 5 "5" dirscanvas_ref 129666
    no_msg
  msg operation_ref 158722 // "paySalary(in amount : int)"
    forward ranks 6 "6" dirscanvas_ref 129410
    no_msg
  msg operation_ref 158722 // "paySalary(in amount : int)"
    forward ranks 7 "7" dirscanvas_ref 130178
    no_msg
  msg operation_ref 160002 // "computeMonthlyBill() : int"
    forward ranks 8 "8" dirscanvas_ref 130690
    no_msg
  msg operation_ref 145410 // "payFromMessAccount(in amount : int, in code : string)"
    forward ranks 9 "9" dirscanvas_ref 129922
    no_msg
  msg operation_ref 138498 // "issueCheck(in name : string, in amount : int, in hallCode : string)"
    forward ranks 10 "10" dirscanvas_ref 129666
    no_msg
  msg operation_ref 145538 // "payFromAmenityAccount(in amount : int, in name : string)"
    forward ranks 11 "11" dirscanvas_ref 129922
    no_msg
  msg operation_ref 158338 // "payFromMiscAccount(in amount : int, in name : string)"
    forward ranks 12 "12" dirscanvas_ref 129922
    no_msg
  msg operation_ref 138498 // "issueCheck(in name : string, in amount : int, in hallCode : string)"
    forward ranks 13 "13" dirscanvas_ref 129666
    no_msg
  msg operation_ref 138370 // "printAccountStatement(in hallCode : string)"
    forward ranks 14 "14" dirscanvas_ref 129666
    no_msg
msgsend
end
