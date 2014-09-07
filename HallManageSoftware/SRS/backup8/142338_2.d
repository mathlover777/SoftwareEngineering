format 76

classinstance 128258 class_ref 128514 // Clerk
  name ""   xyz 603.877 700 2000 life_line_z 2000
classinstance 128386 class_ref 129026 // MessManager
  name ""   xyz 404.989 63 2005 life_line_z 2000
classinstance 128514 class_ref 128258 // Warden
  name ""   xyz 259.803 35 2005 life_line_z 2000
classinstance 128642 class_ref 128898 // HMC
  name ""   xyz 42.94 35 2000 life_line_z 2000
classinstance 129026 class_ref 142210 // DailyWorker
  name ""   xyz 664.074 719 2000 life_line_z 2000
classinstance 129154 class_ref 128130 // Hall
  name ""   xyz 178.588 35 2005 life_line_z 2000
durationcanvas 129282 classinstance_ref 129154 // :Hall
  xyzwh 197 270 2010 11 44
end
durationcanvas 130562 classinstance_ref 128514 // :Warden
  xyzwh 280 66 2010 11 32
end
durationcanvas 130690 classinstance_ref 128514 // :Warden
  xyzwh 280 753 2010 11 97
end
durationcanvas 131074 classinstance_ref 129026 // :DailyWorker
  xyzwh 695 778 2010 11 33
end
durationcanvas 131458 classinstance_ref 129154 // :Hall
  xyzwh 197 479 2010 11 41
end
durationcanvas 133634 classinstance_ref 129154 // :Hall
  xyzwh 197 142 2010 11 33
end
durationcanvas 134146 classinstance_ref 129154 // :Hall
  xyzwh 197 414 2010 11 39
end
durationcanvas 134530 classinstance_ref 129154 // :Hall
  xyzwh 197 357 2010 11 26
end
durationcanvas 134914 classinstance_ref 128642 // :HMC
  xyzwh 61 64 2010 11 63
end
durationcanvas 135426 classinstance_ref 128258 // :Clerk
  xyzwh 622 752 2010 11 33
end
durationcanvas 135810 classinstance_ref 128386 // :MessManager
  xyzwh 440 113 2010 11 41
end
durationcanvas 136322 classinstance_ref 129154 // :Hall
  xyzwh 197 535 2010 11 28
end
durationcanvas 137858 classinstance_ref 128642 // :HMC
  xyzwh 61 157 2010 11 509
end
durationcanvas 145666 classinstance_ref 129154 // :Hall
  xyzwh 197 220 2010 11 25
end
durationcanvas 145922 classinstance_ref 128514 // :Warden
  xyzwh 280 577 2010 11 25
end
durationcanvas 146178 classinstance_ref 128386 // :MessManager
  xyzwh 440 617 2010 11 25
end
durationcanvas 146434 classinstance_ref 128386 // :MessManager
  xyzwh 440 696 2010 11 40
end
durationcanvas 146562 classinstance_ref 129154 // :Hall
  xyzwh 197 696 2010 11 25
end
msg 138626 synchronous
  from durationcanvas_ref 137858
  to durationcanvas_ref 136322
  yz 535 2015 msg operation_ref 137090 // "set_messManager(in value : string) : void"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 83 506
msg 139138 synchronous
  from durationcanvas_ref 137858
  to durationcanvas_ref 131458
  yz 483 2015 msg operation_ref 157442 // "set_wardenId(in value : string) : void"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 111 466
msg 139266 asynchronous
  from durationcanvas_ref 130690
  to durationcanvas_ref 131074
  yz 784 2020 msg operation_ref 153346 // "recruitWorker()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 456 773
msg 139650 synchronous
  from durationcanvas_ref 134914
  to durationcanvas_ref 135810
  yz 113 2015 msg operation_ref 154242 // "recruitWorker()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 352 102
msg 140162 synchronous
  from durationcanvas_ref 134914
  to durationcanvas_ref 130562
  yz 78 2015 msg operation_ref 154114 // "create()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 143 65
msg 140290 asynchronous
  from durationcanvas_ref 130690
  to durationcanvas_ref 135426
  yz 758 2015 msg operation_ref 154370 // "recruitWorker()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 417 747
msg 141314 synchronous
  from durationcanvas_ref 137858
  to durationcanvas_ref 134530
  yz 360 2015 msg operation_ref 132354 // "set_singleRoomRent(in value : int) : void"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 79 344
msg 142466 synchronous
  from durationcanvas_ref 137858
  to durationcanvas_ref 134146
  yz 439 2015 msg operation_ref 132610 // "set_doubleRoomRent(in value : int) : void"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 87 424
msg 142850 synchronous
  from durationcanvas_ref 137858
  to durationcanvas_ref 129282
  yz 301 2020 msg operation_ref 154882 // "addRoom(in type : string)"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 108 288
msg 143234 synchronous
  from durationcanvas_ref 137858
  to durationcanvas_ref 133634
  yz 158 2015 msg operation_ref 154498 // "setupHall()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 110 142
msg 145794 synchronous
  from durationcanvas_ref 137858
  to durationcanvas_ref 145666
  yz 222 2015 msg operation_ref 132098 // "set_status(in value : string) : void"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 105 208
msg 146050 synchronous
  from durationcanvas_ref 137858
  to durationcanvas_ref 145922
  yz 577 2015 msg operation_ref 133506 // "set_hallCode(in value : string) : void"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 141 563
msg 146306 synchronous
  from durationcanvas_ref 137858
  to durationcanvas_ref 146178
  yz 617 2015 msg operation_ref 135810 // "set_hallCode(in value : string) : void"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 230 603
msg 146690 asynchronous
  from durationcanvas_ref 146434
  to durationcanvas_ref 146562
  yz 696 2015 msg operation_ref 159106 // "set_amenityCharge(in value : int) : void"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 274 682
end
