format 76

classinstance 128386 class_ref 128130 // Hall
  name ""   xyz 269.206 35.72 2005 life_line_z 2000
classinstance 128514 class_ref 128002 // Student
  name ""   xyz 30.038 35.72 2000 life_line_z 2000
classinstance 129026 class_ref 129026 // MessManager
  name ""   xyz 354.06 34.72 2005 life_line_z 2000
classinstance 129154 class_ref 128898 // HMC
  name ""   xyz 136.695 33.72 2000 life_line_z 2000
classinstance 142722 class_ref 129154 // Printer
  name ""   xyz 473 34 2000 life_line_z 2000
durationcanvas 129922 classinstance_ref 128514 // :Student
  xyzwh 50 191 2010 11 41
end
durationcanvas 133250 classinstance_ref 129026 // :MessManager
  xyzwh 390 348 2010 11 45
end
durationcanvas 134658 classinstance_ref 128386 // :Hall
  xyzwh 288 208 2010 11 46
end
durationcanvas 135426 classinstance_ref 129154 // :HMC
  xyzwh 155 193 2010 11 99
end
durationcanvas 137986 classinstance_ref 128514 // :Student
  xyzwh 50 345 2010 11 31
end
durationcanvas 142466 classinstance_ref 128514 // :Student
  xyzwh 50 235 2010 11 25
end
durationcanvas 142850 classinstance_ref 142722 // :Printer
  xyzwh 492 256 2010 11 25
end
msg 138626 synchronous
  from durationcanvas_ref 135426
  to durationcanvas_ref 134658
  yz 221 2020 msg operation_ref 157698 // "addStudentToList(in name : string, in id : string, in roomNo : string)"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 177 208
msg 139650 synchronous
  from durationcanvas_ref 135426
  to durationcanvas_ref 129922
  yz 201 2015 msg operation_ref 153986 // "allotRoom()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 88 187
msg 142338 synchronous
  from durationcanvas_ref 133250
  to durationcanvas_ref 137986
  yz 355 3005 msg operation_ref 153218 // "set_messCharge(in value : int) : void"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 141 341
msg 142594 synchronous
  from durationcanvas_ref 135426
  to durationcanvas_ref 142466
  yz 240 2015 msg operation_ref 159746 // "set_roomRent(in value : int) : void"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 71 226
msg 142978 synchronous
  from durationcanvas_ref 135426
  to durationcanvas_ref 142850
  yz 260 2015 msg operation_ref 159874 // "issueAdmissionLetterToStudent(in name : string, in id : string, in hallName : string, in roomNo : string)"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 249 246
end
