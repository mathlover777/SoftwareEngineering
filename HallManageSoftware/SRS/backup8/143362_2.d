format 76

activitycanvas 128002 activity_ref 129026 // payment of salary to mess manager
  show_infonote default drawing_language default show_stereotype_properties default
  xyzwh 34 21 2000 699 463
end
activityactioncanvas 128130 activityaction_ref 134018 // activity action warden computes total monthly bill
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 82 205 2005 100 60
end
activitynodecanvas 128258 activitynode_ref 132226 // initial_node
  xyz 121 144 2005
end
activityactioncanvas 128386 activityaction_ref 134146 // activity action money retrieved from mess account
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 230 124 2005 100 60
end
activityactioncanvas 128514 activityaction_ref 134274 // activity action cheque issued
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 430 124 2005 100 60
end
activityactioncanvas 128642 activityaction_ref 134402 // activity action payment made
  show_infonote default drawing_language default show_stereotype_properties default
  show_opaque_action_definition default
  xyzwh 586 332 2005 100 60
end
activitynodecanvas 129538 activitynode_ref 132354 // activity_final
  xyz 623 418 2005
end
activitypartitioncanvas 129794 activitypartition_ref 136962 // warden
  xyzwh 75 64 2011 136 394
end
activitypartitioncanvas 129922 activitypartition_ref 137090 // hall
  xyzwh 210 64 2011 155 395
end
activitypartitioncanvas 130050 activitypartition_ref 137218 // printer
  xyzwh 365 64 2005 175 396
end
activitypartitioncanvas 130178 activitypartition_ref 137346 // messManager
  xyzwh 538 63 2005 173 397
end
flowcanvas 128770 flow_ref 139650 // <flow>
  
  from ref 128258 z 2006 to ref 128130
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 128898 flow_ref 139778 // <flow>
  
  from ref 128130 z 2006 to point 277 231
  line 129026 z 2006 to ref 128386
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 129154 flow_ref 139906 // <flow>
  
  from ref 128386 z 2006 to ref 128514
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 129282 flow_ref 140034 // <flow>
  
  from ref 128514 z 2006 to point 477 358
  line 129410 z 2006 to ref 128642
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
flowcanvas 129666 flow_ref 140162 // <flow>
  
  from ref 128642 z 2006 to ref 129538
  show_infonote default drawing_language default show_stereotype_properties default write_horizontally default
end
end
