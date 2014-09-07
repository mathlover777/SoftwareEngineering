format 76

packagecanvas 128002 
  package_ref 134786 // warden activity
    xyzwh 19 12 2000 721 767
end
classcanvas 128130 class_ref 128258 // Warden
  class_drawing_mode default show_context_mode default show_stereotype_properties default
  xyz 97 363 2005
end
usecasecanvas 128258 usecase_ref 137730 // make yearly grant request
  xyzwh 184 82 3005 64 32 label_xy 153 114
end
usecasecanvas 128386 usecase_ref 137858 // enter misc. charges
  xyzwh 451 56 3005 64 32 label_xy 435 88
end
usecasecanvas 128514 usecase_ref 137986 // enter number of worker(approx)
  xyzwh 444 122 3005 64 32 label_xy 398 154
end
usecasecanvas 129026 usecase_ref 138114 // enter amenity charge
  xyzwh 194 153 3005 64 32 label_xy 175 185
end
usecasecanvas 129282 usecase_ref 138242 // view room occupancy
  xyzwh 204 230 3005 64 32 label_xy 182 262
end
usecasecanvas 129666 usecase_ref 138370 // pay salary
  xyzwh 200 309 3005 64 32 label_xy 206 341
end
usecasecanvas 129922 usecase_ref 138498 // generate salary list
  xyzwh 487 215 3005 64 32 label_xy 474 244
end
usecasecanvas 130050 usecase_ref 138626 // issue checques to employees
  xyzwh 519 284 3005 64 32 label_xy 479 316
end
usecasecanvas 130434 usecase_ref 138754 // view complaints
  xyzwh 240 407 3005 64 32 label_xy 233 439
end
usecasecanvas 130690 usecase_ref 138882 // post ATR
  xyzwh 504 382 3005 64 32 label_xy 513 414
end
usecasecanvas 130818 usecase_ref 139010 // forward to HMC
  xyzwh 502 490 3005 64 32 label_xy 496 522
end
usecasecanvas 131458 usecase_ref 139138 // print account statement
  xyzwh 238 482 3005 64 32 label_xy 214 514
end
usecasecanvas 131586 usecase_ref 139266 // recruit worker
  xyzwh 216 574 3005 64 32 label_xy 214 606
end
usecasecanvas 131714 usecase_ref 139394 // fire worker
  xyzwh 170 655 3005 64 32 label_xy 175 687
end
usecasecanvas 132226 usecase_ref 139522 // enter daily salary
  xyzwh 383 537 3005 64 32 label_xy 374 569
end
usecasecanvas 132354 usecase_ref 139650 // modify worker database
  xyzwh 387 656 3005 64 32 label_xy 360 688
end
line 128642 ----
  from ref 128130 z 3006 to ref 128258
simplerelationcanvas 128770 simplerelation_ref 137218
  from ref 128258 z 3006 to ref 128386
end
simplerelationcanvas 128898 simplerelation_ref 137346
  from ref 128258 z 3006 to ref 128514
end
line 129154 ----
  from ref 128130 z 3006 to ref 129026
line 129410 ----
  from ref 128130 z 3006 to ref 129282
line 129794 ----
  from ref 128130 z 3006 to ref 129666
simplerelationcanvas 130178 simplerelation_ref 137474
  from ref 129666 z 3006 to ref 130050
end
simplerelationcanvas 130306 simplerelation_ref 137602
  from ref 129922 z 3006 to ref 129666
end
line 130562 ----
  from ref 128130 z 3006 to ref 130434
simplerelationcanvas 131202 simplerelation_ref 137986
  from ref 130690 z 3006 to ref 130434
end
simplerelationcanvas 131330 simplerelation_ref 138114
  from ref 130818 z 3006 to ref 130434
end
line 131842 ----
  from ref 128130 z 3006 to ref 131458
line 131970 ----
  from ref 128130 z 3006 to ref 131586
line 132098 ----
  from ref 128130 z 3006 to ref 131714
simplerelationcanvas 132482 simplerelation_ref 138242
  from ref 131586 z 3006 to ref 132226
end
simplerelationcanvas 132610 simplerelation_ref 138370
  from ref 131586 z 3006 to ref 132354
end
simplerelationcanvas 132738 simplerelation_ref 138498
  from ref 131714 z 3006 to ref 132354
end
end
