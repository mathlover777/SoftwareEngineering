format 76

activitycanvas 128002 activity_ref 128002 // admission
  show_infonote default drawing_language default show_stereotype_properties default
  xyzwh 41 41 2000 715 653
end
activitynodecanvas 128130 activitynode_ref 128130 // initial_node
  xyz 59 208 2005
end
activityactioncanvas 128258 activityaction_ref 128130 // activity action student submits necessary documents
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 89 182 2005 122 76
end
activityactioncanvas 128514 activityaction_ref 128258 // activity action students enters room choice
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 82 422 2005 100 60
end
activitynodecanvas 128898 activitynode_ref 128258 // decision
  xyz 238 296 2005
end
activityactioncanvas 129410 activityaction_ref 128386 // activity action allot room according to student's choice
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 277 182 2005 100 60
end
activityactioncanvas 129538 activityaction_ref 128514 // activity action allot room automatically
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 290 542 2005 100 60
end
activitynodecanvas 129922 activitynode_ref 128386 // merge
  xyz 410 325 2005
end
activityactioncanvas 130306 activityaction_ref 128642 // activity action update hall database
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 458 314 2005 100 60
end
activityactioncanvas 130434 activityaction_ref 128770 // activity action issue letter to student
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 610 314 2005 100 60
end
activitynodecanvas 130946 activitynode_ref 128514 // activity_final
  xyz 648 439 2005
end
activitypartitioncanvas 132994 activitypartition_ref 134658 // student
  xyzwh 51 92 2011 175 579
end
activitypartitioncanvas 133122 activitypartition_ref 134786 // HMC
  xyzwh 224 92 2012 497 579
end
flowcanvas 128386 flow_ref 128002 // <flow>
  
  from ref 128130 z 2006 to ref 128258
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 129026 flow_ref 128130 // if available
  decenter_begin 910
  
  from ref 128514 z 2006 label "if available" xyz 175 356 2006 stereotype "<<decisionInputFlow>>" xyz 175 372 3000 to point 171 311
  line 132866 z 2006 to ref 128898
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 129666 flow_ref 128258 // true
  decenter_begin 754
  
  from ref 128898 z 2006 label "true" xyz 246 245 2006 to point 254 209
  line 132482 z 2006 to ref 129410
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 129794 flow_ref 128386 // false
  
  from ref 128898 z 2006 label "false" xyz 237 443 2006 to point 249 568
  line 132354 z 2006 to ref 129538
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130050 flow_ref 128514 // <flow>
  
  from ref 129538 z 2006 to point 421 568
  line 132738 z 2006 to ref 129922
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130178 flow_ref 128642 // <flow>
  decenter_end 560
  
  from ref 129410 z 2006 to point 422 208
  line 132610 z 2006 to ref 129922
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130562 flow_ref 128770 // <flow>
  decenter_begin 513
  
  from ref 129922 z 2006 to ref 130306
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130690 flow_ref 128898 // <flow>
  
  from ref 130306 z 2006 to ref 130434
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 130818 flow_ref 129026 // <flow>
  decenter_begin 351
  
  from ref 128258 z 2006 to ref 128514
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 131074 flow_ref 129154 // <flow>
  
  from ref 130434 z 2006 to ref 130946
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
end
