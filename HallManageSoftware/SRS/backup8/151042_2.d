format 76

pseudostatecanvas 128002 pseudostate_ref 128642 // initial
   xyz 34 172 2000
end
statecanvas 128130 state_ref 130690 // complaint is created by student
  show_activities default region_horizontally default drawing_language default show_stereotype_properties default
  xyzwh 127 165 2000 195 33
end
statecanvas 128258 state_ref 130818 // complainted is viewed by warden
  show_activities default region_horizontally default drawing_language default show_stereotype_properties default
  xyzwh 399 164 2000 205 33
end
statecanvas 128386 state_ref 130946 // ATR is posted to complaint by warden
  show_activities default region_horizontally default drawing_language default show_stereotype_properties default
  xyzwh 145 272 2000 229 33
end
statecanvas 128514 state_ref 131074 // complaint is forwarded to HMC
  show_activities default region_horizontally default drawing_language default show_stereotype_properties default
  xyzwh 395 393 2000 191 33
end
statecanvas 128642 state_ref 131202 // complaint is view by hmc
  show_activities default region_horizontally default drawing_language default show_stereotype_properties default
  xyzwh 646 393 2005 159 33
end
pseudostatecanvas 128770 pseudostate_ref 128770 // final
   xyz 102 395 2000
end
statecanvas 128898 state_ref 131330 // ATR posted to complaint by HMC
  show_activities default region_horizontally default drawing_language default show_stereotype_properties default
  xyzwh 311 519 2000 199 33
end
pseudostatecanvas 129538 pseudostate_ref 128898 // choice
   xyz 248 392 2000
end
statecanvas 130562 state_ref 131458 // complaint is deleted by student
  show_activities default region_horizontally default drawing_language default show_stereotype_properties default
  xyzwh 82 510 2006 195 33
end
transitioncanvas 129026 transition_ref 131714 // <transition>
  
  from ref 128002 z 2001 to ref 128130
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 129154 transition_ref 131842 // <transition>
  
  from ref 128130 z 2001 to ref 128258
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 129282 transition_ref 131970 // <transition>
  
  from ref 128258 z 2001 to point 498 285
  line 129410 z 2001 to ref 128386
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 129666 transition_ref 132098 // [need to forward to hmc]
  
  from ref 128386 z 2001 label "[need to forward to hmc]" xyz 199 340 2001 to ref 129538
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 129922 transition_ref 132354 // true
  
  from ref 129538 z 2001 label "true" xyz 288 413 2001 to ref 128514
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 130050 transition_ref 132482 // <transition>
  
  from ref 128514 z 2006 to ref 128642
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 130178 transition_ref 132610 // <transition>
  decenter_begin 256
  
  from ref 128642 z 2006 to point 684 533
  line 130306 z 2006 to ref 128898
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 130434 transition_ref 132738 // <transition>
  decenter_begin 90
  decenter_end 801
  
  from ref 128898 z 2001 to ref 128386
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 130690 transition_ref 132866 // false
  
  from ref 129538 z 2001 label "false" xyz 199 412 2001 to point 177 407
  line 130818 z 2001 to ref 130562
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 130946 transition_ref 132994 // <transition>
  decenter_begin 167
  
  from ref 130562 z 2007 to ref 128770
  write_horizontally default show_definition default drawing_language default
end
end
