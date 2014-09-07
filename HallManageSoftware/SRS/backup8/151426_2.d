format 76

pseudostatecanvas 128002 pseudostate_ref 129538 // initial
   xyz 103 74 2000
end
statecanvas 128130 state_ref 133250 // MessManager created
  show_activities default region_horizontally default drawing_language default show_stereotype_properties default
  xyzwh 173 70 2000 203 33
end
statecanvas 128258 state_ref 133378 // MessManager is assigned a hall
  show_activities default region_horizontally default drawing_language default show_stereotype_properties default
  xyzwh 418 71 2000 197 33
end
statecanvas 128386 state_ref 133506 // Monthy payment is paid to mess manager
  show_activities default region_horizontally default drawing_language default show_stereotype_properties default
  xyzwh 390 158 2000 253 33
end
statecanvas 128514 state_ref 133634 // MessManager is Fired
  show_activities default region_horizontally default drawing_language default show_stereotype_properties default
  xyzwh 444 252 2000 143 33
end
pseudostatecanvas 129794 pseudostate_ref 129666 // final
   xyz 503 330 2000
end
transitioncanvas 128642 transition_ref 135426 // <transition>
  
  from ref 128002 z 2001 to ref 128130
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 128770 transition_ref 135554 // <transition>
  
  from ref 128130 z 2001 to ref 128258
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 128898 transition_ref 135682 // <transition>
  
  from ref 128258 z 2001 to ref 128386
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 129026 transition_ref 135810 // <transition>
  decenter_begin 880
  decenter_end 963
  
  from ref 128386 z 2001 to point 611 109
  line 129154 z 2001 to point 735 108
  line 129282 z 2001 to point 736 187
  line 129410 z 2001 to ref 128386
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 129666 transition_ref 135938 // <transition>
  
  from ref 128386 z 2001 to ref 128514
  write_horizontally default show_definition default drawing_language default
end
transitioncanvas 129922 transition_ref 136066 // <transition>
  
  from ref 128514 z 2001 to ref 129794
  write_horizontally default show_definition default drawing_language default
end
end
