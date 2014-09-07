format 76

classinstance 128386 class_ref 128130 // Hall
  name ""   xyz 229.408 9 2005 life_line_z 2000
classinstance 128514 class_ref 128002 // Student
  name ""   xyz 21.165 9 2000 life_line_z 2000
classinstance 145922 class_ref 129154 // Printer
  name ""   xyz 401 4 2000 life_line_z 2000
classinstance 147330 class_ref 128898 // HMC
  name ""   xyz 545 4 2000 life_line_z 2000
durationcanvas 129794 classinstance_ref 128514 // :Student
  xyzwh 41 152 2010 11 388
  overlappingdurationcanvas 146306
    xyzwh 47 197 2020 11 25
  end
  overlappingdurationcanvas 147074
    xyzwh 47 254 2020 11 25
  end
end
durationcanvas 130306 classinstance_ref 128386 // :Hall
  xyzwh 248 376 2010 11 44
end
durationcanvas 135170 classinstance_ref 128386 // :Hall
  xyzwh 248 310 2010 11 43
end
durationcanvas 145666 classinstance_ref 128386 // :Hall
  xyzwh 248 448 2010 11 48
end
durationcanvas 146050 classinstance_ref 145922 // :Printer
  xyzwh 420 509 2010 11 31
end
durationcanvas 146562 classinstance_ref 128386 // :Hall
  xyzwh 248 216 2010 11 25
end
durationcanvas 147458 classinstance_ref 147330 // :HMC
  xyzwh 564 82 2010 11 40
end
msg 138882 synchronous
  from durationcanvas_ref 129794
  to durationcanvas_ref 130306
  yz 378 2015 msg operation_ref 145154 // "addToAmenityAccount(in amount : int)"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 100 364
msg 139906 synchronous
  from durationcanvas_ref 129794
  to durationcanvas_ref 135170
  yz 317 2015 msg operation_ref 145026 // "addToMessAccount(in amount : int)"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 107 303
msg 145794 synchronous
  from durationcanvas_ref 129794
  to durationcanvas_ref 145666
  yz 476 2015 msg operation_ref 159234 // "addToRentAccount(in amount : int)"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 123 462
msg 146178 synchronous
  from durationcanvas_ref 129794
  to durationcanvas_ref 146050
  yz 529 2015 msg operation_ref 159490 // "printPaymentReceipt(in amount : int, in account : string)"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 206 515
reflexivemsg 146434 synchronous
  to durationcanvas_ref 146306
  yz 197 2025 msg operation_ref 153090 // "get_messCharge() : int"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 72 178
msg 146690 synchronous
  from durationcanvas_ref 129794
  to durationcanvas_ref 146562
  yz 218 2015 msg operation_ref 158978 // "get_amenityCharge() : int"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 109 204
reflexivemsg 147202 synchronous
  to durationcanvas_ref 147074
  yz 255 2025 msg operation_ref 159618 // "get_roomRent() : int"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 88 240
reflexivemsg 147586 synchronous
  to durationcanvas_ref 147458
  yz 83 2015 msg operation_ref 166530 // "activatePaymentLink()"
  show_full_operations_definition default drawing_language default show_context_mode default
  label_xy 531 69
end
