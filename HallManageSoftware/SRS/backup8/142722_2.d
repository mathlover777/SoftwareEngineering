format 76

activitycanvas 128002 activity_ref 128130 // complaints
  show_infonote default drawing_language default show_stereotype_properties default
  xyzwh 38 56 2000 777 875
end
activitynodecanvas 128130 activitynode_ref 128642 // initial_node
  xyz 81 181 2005
end
activityactioncanvas 128258 activityaction_ref 128898 // activity action student register a complaint in the website
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 114 158 2005 122 65
end
activityactioncanvas 128514 activityaction_ref 129026 // activity action warden views complaint
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 285 162 2005 100 60
end
activitynodecanvas 128770 activitynode_ref 128770 // decision
  xyz 313 264 2005
end
activityactioncanvas 129410 activityaction_ref 129154 // activity action warden takes action
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 278 587 2005 100 60
end
activityactioncanvas 129538 activityaction_ref 129282 // activity action warden posts ATR
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 278 732 2005 100 60
end
activityactioncanvas 129666 activityaction_ref 129410 // activity action warden forwards complaint to HMC
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 364 266 2005 100 60
end
activityactioncanvas 129794 activityaction_ref 129538 // activity action HMC views the complaints
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 554 162 2005 100 60
end
activityactioncanvas 129922 activityaction_ref 129666 // activity action HMC grants maintance money
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 492 374 2005 100 60
end
activitynodecanvas 130050 activitynode_ref 128898 // merge
  xyz 312 478 2005
end
activityactioncanvas 131074 activityaction_ref 129794 // activity action HMC Posts ATR
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 622 373 2010 100 60
end
activitynodecanvas 131458 activitynode_ref 129026 // decision
  xyz 163 405 2005
end
activitynodecanvas 131842 activitynode_ref 129154 // activity_final
  xyz 72 411 2005
end
activitynodecanvas 133378 activitynode_ref 130690 // fork
  horizontal  xyzwh 523 241 2005 151 15
end
activitynodecanvas 134146 activitynode_ref 130818 // decision
  xyz 593 491 2005
end
activitynodecanvas 134530 activitynode_ref 130946 // decision
  xyz 532 271 2005
end
activitynodecanvas 135426 activitynode_ref 131074 // decision
  xyz 592 565 2005
end
activityactioncanvas 135810 activityaction_ref 131842 // activity action take other action
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 562 647 2005 100 60
end
activitypartitioncanvas 137346 activitypartition_ref 134914 // student
  xyzwh 64 103 2011 180 725
end
activitypartitioncanvas 137474 activitypartition_ref 135042 // warden
  xyzwh 244 103 2012 236 726
end
activitypartitioncanvas 137602 activitypartition_ref 135170 // HMC
  xyzwh 478 103 2011 251 725
end
flowcanvas 128386 flow_ref 129282 // <flow>
  
  from ref 128130 z 2006 to ref 128258
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 128642 flow_ref 129410 // <flow>
  
  from ref 128258 z 2006 to ref 128514
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 129154 flow_ref 129538 // maintainance complaints
  decenter_end 675
  
  from ref 128514 z 2006 label "maintainance complaints" xyz 284 222 2006 to ref 128770
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130178 flow_ref 129666 // false
  
  from ref 128770 z 2006 label "false" xyz 299 372 2006 to ref 130050
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130306 flow_ref 129794 // true
  decenter_begin 754
  decenter_end 400
  
  from ref 128770 z 2006 label "true" xyz 340 293 2006 to ref 129666
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130434 flow_ref 129922 // <flow>
  
  from ref 129666 z 2006 to point 410 189
  line 137730 z 2006 to ref 129794
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130818 flow_ref 130306 // <flow>
  decenter_begin 592
  
  from ref 130050 z 2006 to ref 129410
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130946 flow_ref 130434 // <flow>
  
  from ref 129410 z 2006 to ref 129538
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 131586 flow_ref 130818 // student is satisfied
  decenter_end 754
  
  from ref 129538 z 2006 label "student is satisfied" xyz 100 613 2006 to point 179 758
  line 132866 z 2006 to ref 131458
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 131970 flow_ref 130946 // true
  
  from ref 131458 z 2006 label "true" xyz 119 429 2006 to ref 131842
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 132098 flow_ref 131074 // false
  
  from ref 131458 z 2006 label "false" xyz 179 302 2006 to ref 128258
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 133506 flow_ref 135042 // <flow>
  decenter_begin 340
  decenter_end 435
  
  from ref 129794 z 2006 to ref 133378
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 134018 flow_ref 135298 // <flow>
  decenter_begin 841
  decenter_end 270
  
  from ref 133378 z 2011 to ref 131074
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 134274 flow_ref 135426 // <flow>
  
  from ref 129922 z 2006 to point 539 506
  line 137090 z 2006 to ref 134146
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 134402 flow_ref 135554 // <flow>
  
  from ref 131074 z 2011 to point 669 507
  line 137218 z 2011 to ref 134146
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 134658 flow_ref 135682 // <flow>
  decenter_begin 134
  
  from ref 133378 z 2006 to ref 134530
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 135042 flow_ref 135938 // <flow>
  decenter_begin 360
  
  from ref 134530 z 2006 to ref 129922
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 135170 flow_ref 136066 // <flow>
  
  from ref 134530 z 2006 to point 603 287
  line 135298 z 2006 to ref 134146
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 135554 flow_ref 136194 // <flow>
  
  from ref 134146 z 2006 to ref 135426
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 135682 flow_ref 136322 // <flow>
  
  from ref 135426 z 2006 to point 528 580
  line 136706 z 2006 to point 528 494
  line 136578 z 2006 to ref 130050
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 135938 flow_ref 136450 // <flow>
  decenter_end 430
  
  from ref 135426 z 2006 to ref 135810
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 136450 flow_ref 136706 // <flow>
  
  from ref 135810 z 2006 to point 504 673
  line 136834 z 2006 to point 504 518
  line 136962 z 2006 to ref 130050
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
end
