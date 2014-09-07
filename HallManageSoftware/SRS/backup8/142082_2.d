format 76

classinstance 128130 class_ref 128258 // Warden
  name ""   xyz 300.703 10 2005 life_line_z 2000
classinstance 128258 class_ref 142338 // Complaint
  name ""   xyz 618.256 4 2000 life_line_z 2000
classinstance 128514 class_ref 128002 // Student
  name ""   xyz 12.1651 13 2000 life_line_z 2000
classinstance 129154 class_ref 128898 // HMC
  name ""   xyz 83.92 10 2000 life_line_z 2000
classinstance 145666 class_ref 128130 // Hall
  name ""   xyz 171 12 2000 life_line_z 2000
classinstance 145794 class_ref 129154 // Printer
  name ""   xyz 693 4 2000 life_line_z 2000
durationcanvas 129538 classinstance_ref 128258 // :Complaint
  xyzwh 643 53 2010 11 55
end
durationcanvas 131330 classinstance_ref 128130 // :Warden
  xyzwh 321 467 2010 11 51
end
durationcanvas 131842 classinstance_ref 128258 // :Complaint
  xyzwh 643 179 2010 11 40
end
durationcanvas 132994 classinstance_ref 128258 // :Complaint
  xyzwh 643 277 2010 11 33
end
durationcanvas 133122 classinstance_ref 128258 // :Complaint
  xyzwh 643 542 2010 11 33
end
durationcanvas 133634 classinstance_ref 128258 // :Complaint
  xyzwh 643 224 2010 11 40
end
durationcanvas 134274 classinstance_ref 128130 // :Warden
  xyzwh 321 125 2010 11 126
end
durationcanvas 134914 classinstance_ref 128514 // :Student
  xyzwh 32 68 2010 11 52
end
durationcanvas 136322 classinstance_ref 128258 // :Complaint
  xyzwh 643 468 2010 11 56
end
durationcanvas 137218 classinstance_ref 129154 // :HMC
  xyzwh 102 278 2010 11 93
end
durationcanvas 137346 classinstance_ref 128514 // :Student
  xyzwh 32 541 2010 11 48
end
durationcanvas 137730 classinstance_ref 128258 // :Complaint
  xyzwh 643 331 2010 11 33
end
durationcanvas 138242 classinstance_ref 128258 // :Complaint
  xyzwh 643 123 2010 11 40
end
durationcanvas 145922 classinstance_ref 128130 // :Warden
  xyzwh 321 408 2010 11 40
end
durationcanvas 146050 classinstance_ref 145666 // :Hall
  xyzwh 190 408 2010 11 25
end
durationcanvas 146306 classinstance_ref 145794 // :Printer
  xyzwh 712 437 2010 11 25
end
msg 140418 synchronous
  from durationcanvas_ref 137346
  to durationcanvas_ref 133122
  yz 549 2020 msg operation_ref 155394 // "removeComplaint()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 339 553
msg 142722 synchronous
  from durationcanvas_ref 134274
  to durationcanvas_ref 131842
  yz 188 3005 msg operation_ref 155266 // "postATR()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 443 174
msg 142978 synchronous
  from durationcanvas_ref 137218
  to durationcanvas_ref 132994
  yz 286 2015 msg operation_ref 155138 // "viewComplaint()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 352 274
msg 143490 synchronous
  from durationcanvas_ref 131330
  to durationcanvas_ref 136322
  yz 471 2015 msg operation_ref 155266 // "postATR()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 443 457
msg 143874 synchronous
  from durationcanvas_ref 134274
  to durationcanvas_ref 133634
  yz 233 2015 msg operation_ref 158594 // "forwardToHMC()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 427 219
msg 144258 synchronous
  from durationcanvas_ref 137218
  to durationcanvas_ref 137730
  yz 340 2015 msg operation_ref 155266 // "postATR()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 331 326
msg 144642 synchronous
  from durationcanvas_ref 134274
  to durationcanvas_ref 138242
  yz 131 2015 msg operation_ref 155138 // "viewComplaint()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 429 117
msg 145410 synchronous
  from durationcanvas_ref 134914
  to durationcanvas_ref 129538
  yz 70 2015 msg operation_ref 155010 // "setupComplaint(in message : string)"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 305 56
msg 146178 synchronous
  from durationcanvas_ref 145922
  to durationcanvas_ref 146050
  yz 408 2015 msg operation_ref 145666 // "payFromReapirAccount(in amount : int, in name : string)"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 200 394
msg 146434 synchronous
  from durationcanvas_ref 145922
  to durationcanvas_ref 146306
  yz 437 2015 msg operation_ref 138498 // "issueCheck(in name : string, in amount : int, in hallCode : string)"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 490 423
end
