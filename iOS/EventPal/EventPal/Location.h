//
//  Location.h
//  EventPal
//
//  Created by Yan Kononov on 29/03/2017.
//  Copyright © 2017 Yanislav Kononov. All rights reserved.
//

#import <Realm/Realm.h>
#import <Foundation/Foundation.h>
#import <CoreLocation/CoreLocation.h>

@interface Location : RLMObject
@property(nonatomic) Float32 latitude;
@property(nonatomic) Float32 longtitude;
-(nonnull instancetype) initWithLatitude:(CLLocationDegrees) latitude longitude:(CLLocationDegrees) longtitude;
-(CLLocationCoordinate2D) coordinates;
@end
